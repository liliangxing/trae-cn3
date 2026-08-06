package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/network/TaskTemplate;", "", "id", "", "title", "", "description", "prompt", "logo", RemoteMessageConst.Notification.ICON, "mode", "type", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getDescription", "getPrompt", "getLogo", "getIcon", "getMode", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TaskTemplate {

    @SerializedName("description")
    private final String description;

    @SerializedName(RemoteMessageConst.Notification.ICON)
    private final String icon;

    @SerializedName("id")
    private final int id;

    @SerializedName("logo")
    private final String logo;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final String type;

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final TaskTemplate copy(int id, String title, String description, String prompt, String logo, String icon, String mode, String type) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TaskTemplate(id, title, description, prompt, logo, icon, mode, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskTemplate)) {
            return false;
        }
        TaskTemplate taskTemplate = (TaskTemplate) other;
        return this.id == taskTemplate.id && Intrinsics.areEqual(this.title, taskTemplate.title) && Intrinsics.areEqual(this.description, taskTemplate.description) && Intrinsics.areEqual(this.prompt, taskTemplate.prompt) && Intrinsics.areEqual(this.logo, taskTemplate.logo) && Intrinsics.areEqual(this.icon, taskTemplate.icon) && Intrinsics.areEqual(this.mode, taskTemplate.mode) && Intrinsics.areEqual(this.type, taskTemplate.type);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.prompt.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TaskTemplate(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", prompt=" + this.prompt + ", logo=" + this.logo + ", icon=" + this.icon + ", mode=" + this.mode + ", type=" + this.type + ')';
    }

    public TaskTemplate(int i, String title, String description, String prompt, String logo, String icon, String mode, String type) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = i;
        this.title = title;
        this.description = description;
        this.prompt = prompt;
        this.logo = logo;
        this.icon = icon;
        this.mode = mode;
        this.type = type;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getType() {
        return this.type;
    }
}
