package com.bytedance.trae.home.solo.task;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TaskLocalSearch.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;", "", "<init>", "()V", "search", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "tasks", "query", "", "userQueriesForTask", "Lkotlin/Function1;", "userQueryText", "queryParts", "Lcom/bytedance/trae/im/model/MessagePart;", "containsNormalized", "", "normalizedQuery", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskLocalSearch {
    public static final int $stable = 0;
    public static final TaskLocalSearch INSTANCE = new TaskLocalSearch();

    private TaskLocalSearch() {
    }

    public final List<TaskModel> search(List<TaskModel> tasks, String query, Function1<? super TaskModel, ? extends List<String>> userQueriesForTask) {
        ArrayList arrayList;
        String str;
        Object obj;
        String str2;
        TaskModel taskModel;
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(userQueriesForTask, "userQueriesForTask");
        String obj2 = StringsKt.trim(query).toString();
        if (StringsKt.isBlank(obj2)) {
            return CollectionsKt.emptyList();
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = obj2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList2 = new ArrayList();
        for (TaskModel taskModel2 : tasks) {
            if (INSTANCE.containsNormalized(taskModel2.getTitle(), lowerCase)) {
                arrayList = arrayList2;
                str2 = lowerCase;
                taskModel = taskModel2.copy((r40 & 1) != 0 ? taskModel2.id : null, (r40 & 2) != 0 ? taskModel2.initial : null, (r40 & 4) != 0 ? taskModel2.title : null, (r40 & 8) != 0 ? taskModel2.status : null, (r40 & 16) != 0 ? taskModel2.tag : null, (r40 & 32) != 0 ? taskModel2.location : null, (r40 & 64) != 0 ? taskModel2.time : null, (r40 & 128) != 0 ? taskModel2.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel2.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel2.mode : null, (r40 & 1024) != 0 ? taskModel2.isUnread : false, (r40 & 2048) != 0 ? taskModel2.isPinned : false, (r40 & 4096) != 0 ? taskModel2.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel2.supportsPin : false, (r40 & 16384) != 0 ? taskModel2.isLocal : false, (r40 & 32768) != 0 ? taskModel2.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel2.cliType : null, (r40 & 131072) != 0 ? taskModel2.iconType : null, (r40 & 262144) != 0 ? taskModel2.searchSnippet : "", (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel2.searchQuery : obj2, (r40 & 1048576) != 0 ? taskModel2.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel2.searchAnchorCreatedAtMs : null);
            } else {
                String str3 = lowerCase;
                arrayList = arrayList2;
                Iterator it = ((Iterable) userQueriesForTask.invoke(taskModel2)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = str3;
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    str = str3;
                    if (INSTANCE.containsNormalized((String) obj, str)) {
                        break;
                    }
                    str3 = str;
                }
                String str4 = (String) obj;
                if (str4 != null) {
                    str2 = str;
                    taskModel = taskModel2.copy((r40 & 1) != 0 ? taskModel2.id : null, (r40 & 2) != 0 ? taskModel2.initial : null, (r40 & 4) != 0 ? taskModel2.title : null, (r40 & 8) != 0 ? taskModel2.status : null, (r40 & 16) != 0 ? taskModel2.tag : null, (r40 & 32) != 0 ? taskModel2.location : null, (r40 & 64) != 0 ? taskModel2.time : null, (r40 & 128) != 0 ? taskModel2.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel2.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel2.mode : null, (r40 & 1024) != 0 ? taskModel2.isUnread : false, (r40 & 2048) != 0 ? taskModel2.isPinned : false, (r40 & 4096) != 0 ? taskModel2.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel2.supportsPin : false, (r40 & 16384) != 0 ? taskModel2.isLocal : false, (r40 & 32768) != 0 ? taskModel2.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel2.cliType : null, (r40 & 131072) != 0 ? taskModel2.iconType : null, (r40 & 262144) != 0 ? taskModel2.searchSnippet : str4, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel2.searchQuery : obj2, (r40 & 1048576) != 0 ? taskModel2.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel2.searchAnchorCreatedAtMs : null);
                } else {
                    str2 = str;
                    taskModel = null;
                }
            }
            ArrayList arrayList3 = arrayList;
            if (taskModel != null) {
                arrayList3.add(taskModel);
            }
            arrayList2 = arrayList3;
            lowerCase = str2;
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        if (r4 != null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String userQueryText(List<MessagePart> queryParts) {
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        List<MessagePart> list = queryParts;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<MessagePart> arrayList = new ArrayList();
        for (Object obj : queryParts) {
            if (Intrinsics.areEqual(((MessagePart) obj).getType(), "text")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (MessagePart messagePart : arrayList) {
            JsonObject data = messagePart.getData();
            if (data != null && (jsonElement2 = data.get(ReportConstant.COMMON_CONTENT)) != null) {
                if (!jsonElement2.isJsonPrimitive()) {
                    jsonElement2 = null;
                }
                if (jsonElement2 != null) {
                    str = jsonElement2.getAsString();
                }
            }
            JsonObject data2 = messagePart.getData();
            if (data2 != null && (jsonElement = data2.get("text_content")) != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null) {
                    str = jsonElement.getAsString();
                    if (str == null) {
                        arrayList2.add(str);
                    }
                }
            }
            str = null;
            if (str == null) {
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (!StringsKt.isBlank(joinToString$default)) {
            return joinToString$default;
        }
        return null;
    }

    private final boolean containsNormalized(String str, String str2) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.contains$default(lowerCase, str2, false, 2, (Object) null);
    }
}
