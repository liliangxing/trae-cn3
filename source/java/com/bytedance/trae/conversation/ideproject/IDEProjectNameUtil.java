package com.bytedance.trae.conversation.ideproject;

import android.content.Context;
import com.bytedance.trae.conversation.C0637R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IDEProjectNameUtil.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;", "", "<init>", "()V", "getProjectName", "", "context", "Landroid/content/Context;", "folderPath", "workspaceType", "formatMultiRoot", "Lkotlin/Function1;", "formatUnsavedMultiRoot", "getProjectName$conversation_mainlandRelease", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDEProjectNameUtil {
    public static final IDEProjectNameUtil INSTANCE = new IDEProjectNameUtil();

    private IDEProjectNameUtil() {
    }

    public final String getProjectName(final Context context, String folderPath, String workspaceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(workspaceType, "workspaceType");
        return getProjectName$conversation_mainlandRelease(folderPath, workspaceType, new Function1() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String projectName$lambda$0;
                projectName$lambda$0 = IDEProjectNameUtil.getProjectName$lambda$0(context, (String) obj);
                return projectName$lambda$0;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String projectName$lambda$1;
                projectName$lambda$1 = IDEProjectNameUtil.getProjectName$lambda$1(context, (String) obj);
                return projectName$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getProjectName$lambda$0(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "folderName");
        String string = context.getString(C0637R.string.trae_ide_project_name_workspace, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getProjectName$lambda$1(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "folderName");
        String string = context.getString(C0637R.string.trae_ide_project_name_unsaved_workspace, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getProjectName$conversation_mainlandRelease(String folderPath, String workspaceType, Function1<? super String, String> formatMultiRoot, Function1<? super String, String> formatUnsavedMultiRoot) {
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(workspaceType, "workspaceType");
        Intrinsics.checkNotNullParameter(formatMultiRoot, "formatMultiRoot");
        Intrinsics.checkNotNullParameter(formatUnsavedMultiRoot, "formatUnsavedMultiRoot");
        List split$default = StringsKt.split$default(StringsKt.trimEnd(folderPath, new char[]{'/', '\\'}), new char[]{'/', '\\'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String str = (String) CollectionsKt.lastOrNull(arrayList);
        if (str == null) {
            str = "";
        }
        int hashCode = workspaceType.hashCode();
        if (hashCode != -1731779975) {
            return hashCode != -1560422023 ? (hashCode == 1249558568 && workspaceType.equals("multi_root")) ? (String) formatMultiRoot.invoke(str) : str : !workspaceType.equals("unsaved_multi_root") ? str : (String) formatUnsavedMultiRoot.invoke(str);
        }
        workspaceType.equals("single_root");
        return str;
    }
}
