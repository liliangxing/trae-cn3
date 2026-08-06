package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.home.C0820R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskIconType;", "", "iconRes", "", "<init>", "(Ljava/lang/String;II)V", "getIconRes", "()I", "PPT", "CODE", "WEBSITE", "APP", "IMAGE", "DESIGN", "DOCUMENT", "RESEARCH", "DATA", "BUSINESS", "PERSONAL", "CHAT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskIconType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TaskIconType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int iconRes;
    public static final TaskIconType PPT = new TaskIconType("PPT", 0, C0820R.drawable.ic_solo_task_ppt);
    public static final TaskIconType CODE = new TaskIconType("CODE", 1, C0820R.drawable.ic_solo_task_code_type);
    public static final TaskIconType WEBSITE = new TaskIconType("WEBSITE", 2, C0820R.drawable.ic_solo_task_web);
    public static final TaskIconType APP = new TaskIconType("APP", 3, C0820R.drawable.ic_solo_task_app);
    public static final TaskIconType IMAGE = new TaskIconType("IMAGE", 4, C0820R.drawable.ic_solo_task_image);
    public static final TaskIconType DESIGN = new TaskIconType("DESIGN", 5, C0820R.drawable.ic_solo_task_design);
    public static final TaskIconType DOCUMENT = new TaskIconType("DOCUMENT", 6, C0820R.drawable.ic_solo_task_document);
    public static final TaskIconType RESEARCH = new TaskIconType("RESEARCH", 7, C0820R.drawable.ic_solo_task_research);
    public static final TaskIconType DATA = new TaskIconType("DATA", 8, C0820R.drawable.ic_solo_task_data);
    public static final TaskIconType BUSINESS = new TaskIconType("BUSINESS", 9, C0820R.drawable.ic_solo_task_business);
    public static final TaskIconType PERSONAL = new TaskIconType("PERSONAL", 10, C0820R.drawable.ic_solo_task_personal);
    public static final TaskIconType CHAT = new TaskIconType("CHAT", 11, C0820R.drawable.ic_solo_task_chat);

    private static final /* synthetic */ TaskIconType[] $values() {
        return new TaskIconType[]{PPT, CODE, WEBSITE, APP, IMAGE, DESIGN, DOCUMENT, RESEARCH, DATA, BUSINESS, PERSONAL, CHAT};
    }

    public static EnumEntries<TaskIconType> getEntries() {
        return $ENTRIES;
    }

    private TaskIconType(String str, int i, int i2) {
        this.iconRes = i2;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    static {
        TaskIconType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: TaskModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;", "", "<init>", "()V", "fromString", "Lcom/bytedance/trae/home/solo/task/TaskIconType;", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r2.equals("website") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        
            return com.bytedance.trae.home.solo.task.TaskIconType.WEBSITE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        
            if (r2.equals("document") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        
            return com.bytedance.trae.home.solo.task.TaskIconType.DOCUMENT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
        
            if (r2.equals("web") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
        
            if (r2.equals(com.bytedance.trae.im.model.MessagePart.TYPE_DOC) == false) goto L69;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x002b. Please report as an issue. */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TaskIconType fromString(String value) {
            String str = value;
            if (str == null || StringsKt.isBlank(str)) {
                return TaskIconType.CHAT;
            }
            String lowerCase = StringsKt.trim(str).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1335246402:
                    if (lowerCase.equals("design")) {
                        return TaskIconType.DESIGN;
                    }
                    return TaskIconType.CHAT;
                case -1146830912:
                    if (lowerCase.equals("business")) {
                        return TaskIconType.BUSINESS;
                    }
                    return TaskIconType.CHAT;
                case -350895717:
                    if (lowerCase.equals("research")) {
                        return TaskIconType.RESEARCH;
                    }
                    return TaskIconType.CHAT;
                case 96801:
                    if (lowerCase.equals("app")) {
                        return TaskIconType.APP;
                    }
                    return TaskIconType.CHAT;
                case 99640:
                    break;
                case 111220:
                    if (lowerCase.equals("ppt")) {
                        return TaskIconType.PPT;
                    }
                    return TaskIconType.CHAT;
                case 117588:
                    break;
                case 3052376:
                    if (lowerCase.equals(BMVoiceChatSessionManager.SCENE_ID_CHAT)) {
                        return TaskIconType.CHAT;
                    }
                    return TaskIconType.CHAT;
                case 3059181:
                    if (lowerCase.equals("code")) {
                        return TaskIconType.CODE;
                    }
                    return TaskIconType.CHAT;
                case 3076010:
                    if (lowerCase.equals("data")) {
                        return TaskIconType.DATA;
                    }
                    return TaskIconType.CHAT;
                case 100313435:
                    if (lowerCase.equals("image")) {
                        return TaskIconType.IMAGE;
                    }
                    return TaskIconType.CHAT;
                case 443164224:
                    if (lowerCase.equals("personal")) {
                        return TaskIconType.PERSONAL;
                    }
                    return TaskIconType.CHAT;
                case 861720859:
                    break;
                case 1224335515:
                    break;
                default:
                    return TaskIconType.CHAT;
            }
        }
    }

    public static TaskIconType valueOf(String str) {
        return (TaskIconType) Enum.valueOf(TaskIconType.class, str);
    }

    public static TaskIconType[] values() {
        return (TaskIconType[]) $VALUES.clone();
    }
}
