package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TasksListDetailCardCreator.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "collectTodoItems", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;", "buildTodoListView", "Landroid/view/View;", "items", "buildTodoRow", "density", "", "item", "Companion", "TodoStatus", "TodoItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TasksListDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: TasksListDetailCardCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TodoStatus.values().length];
            try {
                iArr[TodoStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TodoStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TodoStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: TasksListDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        String string;
        Function1 function1;
        String str;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z4 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<TodoItem> collectTodoItems = collectTodoItems(toolCallInfo);
        if (!z4) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_todo_updating);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            function1 = collectTodoItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$0;
                    onCreateDetail$lambda$0 = TasksListDetailCardCreator.onCreateDetail$lambda$0(TasksListDetailCardCreator.this, collectTodoItems, (Context) obj);
                    return onCreateDetail$lambda$0;
                }
            } : null;
            str = string2;
            z2 = true;
        } else {
            List<TodoItem> list = collectTodoItems;
            if (!list.isEmpty()) {
                List<TodoItem> list2 = collectTodoItems;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (!(((TodoItem) it.next()).getStatus() == TodoStatus.COMPLETED)) {
                            z3 = false;
                            break;
                        }
                    }
                }
                z3 = true;
                if (z3) {
                    z = true;
                    if (!z) {
                        string = context.getString(C0637R.string.trae_chat_tool_todo_all_completed);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    } else {
                        int size = collectTodoItems.size();
                        if (size > 0) {
                            string = context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_todo_count, size, Integer.valueOf(size));
                            Intrinsics.checkNotNull(string);
                        } else {
                            string = context.getString(C0637R.string.trae_chat_tool_todo_updating);
                            Intrinsics.checkNotNull(string);
                        }
                    }
                    function1 = list.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            View onCreateDetail$lambda$2;
                            onCreateDetail$lambda$2 = TasksListDetailCardCreator.onCreateDetail$lambda$2(TasksListDetailCardCreator.this, collectTodoItems, (Context) obj);
                            return onCreateDetail$lambda$2;
                        }
                    } : null;
                    str = string;
                    z2 = false;
                }
            }
            z = false;
            if (!z) {
            }
            if (list.isEmpty() ^ true) {
            }
            str = string;
            z2 = false;
        }
        Function1 function12 = function1;
        FLogger.INSTANCE.i("AgentTool", "[TasksListCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", tasks=" + collectTodoItems.size());
        return new ToolDetailCard("", C0637R.drawable.todo, 0, str, null, null, function12, fromString, z2, null, 548, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$0(TasksListDetailCardCreator tasksListDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return tasksListDetailCardCreator.buildTodoListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$2(TasksListDetailCardCreator tasksListDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return tasksListDetailCardCreator.buildTodoListView(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        String string;
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        List<TodoItem> collectTodoItems = collectTodoItems(toolCallInfo);
        if (!z3) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_todo_updating);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            card.setSubtitle(null);
            card.setShimmerTitle(true);
        } else {
            card.setShimmerTitle(false);
            if (!collectTodoItems.isEmpty()) {
                List<TodoItem> list = collectTodoItems;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (!(((TodoItem) it.next()).getStatus() == TodoStatus.COMPLETED)) {
                            z2 = false;
                            break;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                    z = true;
                    if (!z) {
                        String string3 = context.getString(C0637R.string.trae_chat_tool_todo_all_completed);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        card.setTitle(string3);
                        card.setSubtitle(null);
                    } else {
                        int size = collectTodoItems.size();
                        if (size > 0) {
                            string = context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_todo_count, size, Integer.valueOf(size));
                            Intrinsics.checkNotNull(string);
                        } else {
                            string = context.getString(C0637R.string.trae_chat_tool_todo_updating);
                            Intrinsics.checkNotNull(string);
                        }
                        card.setTitle(string);
                        card.setSubtitle(null);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[TasksListCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", tasks=" + collectTodoItems.size());
    }

    private final List<TodoItem> collectTodoItems(ParsedToolCallInfo toolCallInfo) {
        JsonElement jsonElement;
        JsonArray asJsonArray;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        String asString;
        String str;
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement = params.get("todos")) != null) {
            if (!jsonElement.isJsonArray()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
                List createListBuilder = CollectionsKt.createListBuilder();
                int size = asJsonArray.size();
                for (int i = 0; i < size; i++) {
                    JsonElement jsonElement3 = asJsonArray.get(i);
                    if (jsonElement3 != null) {
                        if (!jsonElement3.isJsonObject()) {
                            jsonElement3 = null;
                        }
                        if (jsonElement3 != null && (asJsonObject = jsonElement3.getAsJsonObject()) != null && (jsonElement2 = asJsonObject.get(ReportConstant.COMMON_CONTENT)) != null) {
                            if (!jsonElement2.isJsonPrimitive()) {
                                jsonElement2 = null;
                            }
                            if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                                JsonElement jsonElement4 = asJsonObject.get(PageDataManager.EXTRA_STATUS);
                                if (jsonElement4 != null) {
                                    if (!jsonElement4.isJsonPrimitive()) {
                                        jsonElement4 = null;
                                    }
                                    if (jsonElement4 != null) {
                                        str = jsonElement4.getAsString();
                                        createListBuilder.add(new TodoItem(asString, TodoStatus.INSTANCE.fromString(str)));
                                    }
                                }
                                str = null;
                                createListBuilder.add(new TodoItem(asString, TodoStatus.INSTANCE.fromString(str)));
                            }
                        }
                    }
                }
                return CollectionsKt.build(createListBuilder);
            }
        }
        return CollectionsKt.emptyList();
    }

    private final View buildTodoListView(Context context, List<TodoItem> items) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<T> it = items.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            View buildTodoRow = buildTodoRow(context, f, (TodoItem) it.next());
            if (i > 0) {
                ViewGroup.LayoutParams layoutParams = buildTodoRow.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = (int) (4 * f);
                }
            }
            linearLayout.addView(buildTodoRow);
            i = i2;
        }
        return linearLayout;
    }

    private final View buildTodoRow(Context context, float density, TodoItem item) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * density));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i = (int) (16 * density);
        int i2 = WhenMappings.$EnumSwitchMapping$0[item.getStatus().ordinal()];
        if (i2 == 1) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(C0637R.drawable.checkmark_circle_1);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i));
        } else if (i2 == 2) {
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(C0637R.drawable.in_process);
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            linearLayout.addView(imageView2, new LinearLayout.LayoutParams(i, i));
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            int i3 = (int) (14 * density);
            View view = new View(context);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setStroke((int) (1.17f * density), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2));
            gradientDrawable.setColor(0);
            view.setBackground(gradientDrawable);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view, new FrameLayout.LayoutParams(i3, i3, 17));
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(i, i));
        }
        TextView textView = new TextView(context);
        textView.setText(item.getContent());
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (4 * density));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TasksListDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "IN_PROGRESS", "COMPLETED", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class TodoStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TodoStatus[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final TodoStatus PENDING = new TodoStatus("PENDING", 0);
        public static final TodoStatus IN_PROGRESS = new TodoStatus("IN_PROGRESS", 1);
        public static final TodoStatus COMPLETED = new TodoStatus("COMPLETED", 2);

        private static final /* synthetic */ TodoStatus[] $values() {
            return new TodoStatus[]{PENDING, IN_PROGRESS, COMPLETED};
        }

        public static EnumEntries<TodoStatus> getEntries() {
            return $ENTRIES;
        }

        private TodoStatus(String str, int i) {
        }

        static {
            TodoStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: TasksListDetailCardCreator.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus$Companion;", "", "<init>", "()V", "fromString", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;", PageDataManager.EXTRA_STATUS, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TodoStatus fromString(String status) {
                return Intrinsics.areEqual(status, "completed") ? TodoStatus.COMPLETED : Intrinsics.areEqual(status, "in_progress") ? TodoStatus.IN_PROGRESS : TodoStatus.PENDING;
            }
        }

        public static TodoStatus valueOf(String str) {
            return (TodoStatus) Enum.valueOf(TodoStatus.class, str);
        }

        public static TodoStatus[] values() {
            return (TodoStatus[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TasksListDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoItem;", "", ReportConstant.COMMON_CONTENT, "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;)V", "getContent", "()Ljava/lang/String;", "getStatus", "()Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TodoItem {
        private final String content;
        private final TodoStatus status;

        public static /* synthetic */ TodoItem copy$default(TodoItem todoItem, String str, TodoStatus todoStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = todoItem.content;
            }
            if ((i & 2) != 0) {
                todoStatus = todoItem.status;
            }
            return todoItem.copy(str, todoStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final TodoStatus getStatus() {
            return this.status;
        }

        public final TodoItem copy(String content, TodoStatus status) {
            Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
            Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
            return new TodoItem(content, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TodoItem)) {
                return false;
            }
            TodoItem todoItem = (TodoItem) other;
            return Intrinsics.areEqual(this.content, todoItem.content) && this.status == todoItem.status;
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + this.status.hashCode();
        }

        public String toString() {
            return "TodoItem(content=" + this.content + ", status=" + this.status + ')';
        }

        public TodoItem(String str, TodoStatus todoStatus) {
            Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
            Intrinsics.checkNotNullParameter(todoStatus, PageDataManager.EXTRA_STATUS);
            this.content = str;
            this.status = todoStatus;
        }

        public final String getContent() {
            return this.content;
        }

        public final TodoStatus getStatus() {
            return this.status;
        }
    }
}
