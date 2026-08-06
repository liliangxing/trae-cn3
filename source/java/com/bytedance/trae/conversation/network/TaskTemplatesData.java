package com.bytedance.trae.conversation.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/network/TaskTemplatesData;", "", "templates", "", "Lcom/bytedance/trae/conversation/network/TaskTemplate;", "<init>", "(Ljava/util/List;)V", "getTemplates", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TaskTemplatesData {

    @SerializedName("templates")
    private final List<TaskTemplate> templates;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskTemplatesData() {
        this(r0, 1, r0);
        List list = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskTemplatesData copy$default(TaskTemplatesData taskTemplatesData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = taskTemplatesData.templates;
        }
        return taskTemplatesData.copy(list);
    }

    public final List<TaskTemplate> component1() {
        return this.templates;
    }

    public final TaskTemplatesData copy(List<TaskTemplate> templates) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        return new TaskTemplatesData(templates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TaskTemplatesData) && Intrinsics.areEqual(this.templates, ((TaskTemplatesData) other).templates);
    }

    public int hashCode() {
        return this.templates.hashCode();
    }

    public String toString() {
        return "TaskTemplatesData(templates=" + this.templates + ')';
    }

    public TaskTemplatesData(List<TaskTemplate> list) {
        Intrinsics.checkNotNullParameter(list, "templates");
        this.templates = list;
    }

    public /* synthetic */ TaskTemplatesData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<TaskTemplate> getTemplates() {
        return this.templates;
    }
}
