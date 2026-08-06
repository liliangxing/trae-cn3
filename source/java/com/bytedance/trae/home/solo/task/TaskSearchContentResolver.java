package com.bytedance.trae.home.solo.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TaskSearchContentResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J.\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005JD\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;", "", "<init>", "()V", "displayTasks", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "taskFlowTasks", "isSearchMode", "", "query", "", "searchResults", "isSearchPending", "isSearchLoading", "shouldWaitForListCommitBeforeShowingContent", "tasks", "hasError", "shouldSuppressListItemAnimations", "isSearching", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskSearchContentResolver {
    public static final int $stable = 0;
    public static final TaskSearchContentResolver INSTANCE = new TaskSearchContentResolver();

    private TaskSearchContentResolver() {
    }

    public final List<TaskModel> displayTasks(List<TaskModel> taskFlowTasks, boolean isSearchMode, String query, List<TaskModel> searchResults) {
        Intrinsics.checkNotNullParameter(taskFlowTasks, "taskFlowTasks");
        Intrinsics.checkNotNullParameter(query, "query");
        return isSearching(isSearchMode, query) ? searchResults == null ? CollectionsKt.emptyList() : searchResults : taskFlowTasks;
    }

    public final boolean isSearchPending(boolean isSearchMode, String query, boolean isSearchLoading, List<TaskModel> searchResults) {
        Intrinsics.checkNotNullParameter(query, "query");
        return isSearching(isSearchMode, query) && (isSearchLoading || searchResults == null);
    }

    public final boolean shouldWaitForListCommitBeforeShowingContent(List<TaskModel> tasks, boolean hasError, boolean isSearchMode, String query, boolean isSearchLoading, List<TaskModel> searchResults) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(query, "query");
        if ((!hasError || isSearching(isSearchMode, query)) && !isSearchPending(isSearchMode, query, isSearchLoading, searchResults)) {
            return !tasks.isEmpty();
        }
        return false;
    }

    public final boolean shouldSuppressListItemAnimations(boolean isSearchMode, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return isSearching(isSearchMode, query);
    }

    private final boolean isSearching(boolean isSearchMode, String query) {
        if (isSearchMode) {
            return StringsKt.trim(query).toString().length() > 0;
        }
        return false;
    }
}
