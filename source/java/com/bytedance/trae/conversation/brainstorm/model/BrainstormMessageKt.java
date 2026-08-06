package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: BrainstormMessage.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"SUB_TASK_ID_HEAD_REGEX", "Lkotlin/text/Regex;", "SUB_TASK_ID_TAIL_REGEX", "SUB_TASK_ID_HEAD_PREFIX", "", "SUB_TASK_ID_HEAD_FIXED_PREFIXES", "", "SUB_TASK_ID_HEAD_MAX_LEN", "", "SUB_TASK_ID_HEAD_VARIABLE_TAIL", "parseAttachedSubTaskId", "Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;", "text", "isIncompleteHeadPrefix", "", "normalizeSubTaskId", AccountMonitorConstants.CommonParameter.RAW, "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormMessageKt {
    private static final int SUB_TASK_ID_HEAD_MAX_LEN = 100;
    private static final String SUB_TASK_ID_HEAD_PREFIX = "(task_task_";
    private static final Regex SUB_TASK_ID_HEAD_REGEX = new Regex("^\\((task_task_(?:create|update|stop)_\\d+_[0-9a-zA-Z\\s]+)(?:,([a-zA-Z_]+))?\\)");
    private static final Regex SUB_TASK_ID_TAIL_REGEX = new Regex("\\s*\\((task_task_(?:create|update|stop)_\\d+_[0-9a-zA-Z\\s]+)(?:,([a-zA-Z_]+))?\\)\\s*$");
    private static final List<String> SUB_TASK_ID_HEAD_FIXED_PREFIXES = CollectionsKt.listOf(new String[]{"(task_task_create_", "(task_task_update_", "(task_task_stop_"});
    private static final Regex SUB_TASK_ID_HEAD_VARIABLE_TAIL = new Regex("\\d*(?:_[0-9a-zA-Z\\s]{0,32})?(?:,[a-zA-Z_]*)?");

    /* JADX WARN: Removed duplicated region for block: B:10:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParsedSubTaskTag parseAttachedSubTaskId(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(str, "text");
        String str6 = str;
        MatchResult find$default = Regex.find$default(SUB_TASK_ID_HEAD_REGEX, str6, 0, 2, (Object) null);
        if (find$default != null) {
            String substring = str.substring(find$default.getRange().getLast() + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            MatchResult find$default2 = Regex.find$default(SUB_TASK_ID_TAIL_REGEX, substring, 0, 2, (Object) null);
            if (find$default2 != null) {
                String substring2 = substring.substring(0, find$default2.getRange().getFirst());
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                String obj = StringsKt.trimEnd(substring2).toString();
                if (obj != null) {
                    str3 = obj;
                    String normalizeSubTaskId = normalizeSubTaskId((String) find$default.getGroupValues().get(1));
                    str4 = (String) CollectionsKt.getOrNull(find$default.getGroupValues(), 2);
                    if (str4 != null) {
                        if (str4.length() > 0) {
                            str5 = str4;
                            return new ParsedSubTaskTag(str3, normalizeSubTaskId, str5, false, 8, null);
                        }
                    }
                    str5 = null;
                    return new ParsedSubTaskTag(str3, normalizeSubTaskId, str5, false, 8, null);
                }
            }
            str3 = substring;
            String normalizeSubTaskId2 = normalizeSubTaskId((String) find$default.getGroupValues().get(1));
            str4 = (String) CollectionsKt.getOrNull(find$default.getGroupValues(), 2);
            if (str4 != null) {
            }
            str5 = null;
            return new ParsedSubTaskTag(str3, normalizeSubTaskId2, str5, false, 8, null);
        }
        MatchResult find$default3 = Regex.find$default(SUB_TASK_ID_TAIL_REGEX, str6, 0, 2, (Object) null);
        if (find$default3 != null) {
            String substring3 = str.substring(0, find$default3.getRange().getFirst());
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            String obj2 = StringsKt.trimEnd(substring3).toString();
            String normalizeSubTaskId3 = normalizeSubTaskId((String) find$default3.getGroupValues().get(1));
            String str7 = (String) CollectionsKt.getOrNull(find$default3.getGroupValues(), 2);
            if (str7 != null) {
                if (str7.length() > 0) {
                    str2 = str7;
                    return new ParsedSubTaskTag(obj2, normalizeSubTaskId3, str2, false, 8, null);
                }
            }
            str2 = null;
            return new ParsedSubTaskTag(obj2, normalizeSubTaskId3, str2, false, 8, null);
        }
        if (isIncompleteHeadPrefix(str)) {
            return new ParsedSubTaskTag("", null, null, true, 4, null);
        }
        return new ParsedSubTaskTag(str, null, null, false, 12, null);
    }

    private static final boolean isIncompleteHeadPrefix(String str) {
        Object obj = null;
        if (!StringsKt.startsWith$default(str, "(", false, 2, (Object) null) || StringsKt.contains$default(str, ')', false, 2, (Object) null) || str.length() > 100) {
            return false;
        }
        if (str.length() <= 11) {
            return StringsKt.startsWith$default(SUB_TASK_ID_HEAD_PREFIX, str, false, 2, (Object) null);
        }
        Iterator<T> it = SUB_TASK_ID_HEAD_FIXED_PREFIXES.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str2 = (String) next;
            if ((str.length() <= str2.length() && StringsKt.startsWith$default(str2, str, false, 2, (Object) null)) || StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                obj = next;
                break;
            }
        }
        String str3 = (String) obj;
        if (str3 == null) {
            return false;
        }
        if (str.length() <= str3.length()) {
            return true;
        }
        String substring = str.substring(str3.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return SUB_TASK_ID_HEAD_VARIABLE_TAIL.matches(substring);
    }

    private static final String normalizeSubTaskId(String str) {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (!CharsKt.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
