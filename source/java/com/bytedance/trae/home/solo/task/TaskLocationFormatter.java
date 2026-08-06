package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.C0637R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TaskLocationFormatter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;", "", "<init>", "()V", "formatIdeLocation", "", "ownerProjectAbsolutePath", "ownerProjectWorkspaceStatus", "fallbackWorkspace", "lastPathComponent", "path", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskLocationFormatter {
    public static final int $stable = 0;
    public static final TaskLocationFormatter INSTANCE = new TaskLocationFormatter();

    private TaskLocationFormatter() {
    }

    public final String formatIdeLocation(String ownerProjectAbsolutePath, String ownerProjectWorkspaceStatus, String fallbackWorkspace) {
        if (ownerProjectAbsolutePath != null) {
            if (!(!StringsKt.isBlank(ownerProjectAbsolutePath))) {
                ownerProjectAbsolutePath = null;
            }
            if (ownerProjectAbsolutePath != null) {
                fallbackWorkspace = ownerProjectAbsolutePath;
            }
        }
        String lastPathComponent = lastPathComponent(fallbackWorkspace);
        if (ownerProjectWorkspaceStatus == null) {
            return lastPathComponent;
        }
        int hashCode = ownerProjectWorkspaceStatus.hashCode();
        if (hashCode == -1731779975) {
            ownerProjectWorkspaceStatus.equals("single_root");
            return lastPathComponent;
        }
        if (hashCode == -1560422023) {
            if (!ownerProjectWorkspaceStatus.equals("unsaved_multi_root")) {
                return lastPathComponent;
            }
            String string = AppHost.INSTANCE.getApplication().getString(C0637R.string.trae_ide_project_name_unsaved_workspace, new Object[]{lastPathComponent});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (hashCode != 1249558568 || !ownerProjectWorkspaceStatus.equals("multi_root")) {
            return lastPathComponent;
        }
        String string2 = AppHost.INSTANCE.getApplication().getString(C0637R.string.trae_ide_project_name_workspace, new Object[]{lastPathComponent});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final String lastPathComponent(String path) {
        String str = path;
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        if (StringsKt.endsWith$default(path, ".git", false, 2, (Object) null)) {
            path = StringsKt.dropLast(path, 4);
        }
        List split$default = StringsKt.split$default(StringsKt.trimEnd(path, new char[]{'/', '\\'}), new char[]{'/', '\\'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String str2 = (String) CollectionsKt.lastOrNull(arrayList);
        return str2 == null ? "" : str2;
    }
}
