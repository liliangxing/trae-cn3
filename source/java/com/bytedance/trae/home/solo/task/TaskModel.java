package com.bytedance.trae.home.solo.task;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0017HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jñ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010M\u001a\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010O\u001a\u00020PH×\u0001J\t\u0010Q\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010+R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010+R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010+R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 ¨\u0006R"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskModel;", "", "id", "", "initial", "title", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/home/solo/task/TaskStatus;", "tag", "location", DBData.FIELD_TIME, "updatedAt", "cliId", "mode", "isUnread", "", "isPinned", "pinnedAt", "supportsPin", "isLocal", "isDeviceOnline", "cliType", "iconType", "Lcom/bytedance/trae/home/solo/task/TaskIconType;", "searchSnippet", "searchQuery", "searchHighlightKeywords", "", "searchAnchorCreatedAtMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/home/solo/task/TaskStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZZZLjava/lang/String;Lcom/bytedance/trae/home/solo/task/TaskIconType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getInitial", "getTitle", "getStatus", "()Lcom/bytedance/trae/home/solo/task/TaskStatus;", "getTag", "getLocation", "getTime", "getUpdatedAt", "getCliId", "getMode", "()Z", "getPinnedAt", "getSupportsPin", "getCliType", "getIconType", "()Lcom/bytedance/trae/home/solo/task/TaskIconType;", "getSearchSnippet", "getSearchQuery", "getSearchHighlightKeywords", "()Ljava/util/List;", "getSearchAnchorCreatedAtMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TaskModel {
    public static final int $stable = 8;
    private final String cliId;
    private final String cliType;
    private final TaskIconType iconType;
    private final String id;
    private final String initial;
    private final boolean isDeviceOnline;
    private final boolean isLocal;
    private final boolean isPinned;
    private final boolean isUnread;
    private final String location;
    private final String mode;
    private final String pinnedAt;
    private final String searchAnchorCreatedAtMs;
    private final List<String> searchHighlightKeywords;
    private final String searchQuery;
    private final String searchSnippet;
    private final TaskStatus status;
    private final boolean supportsPin;
    private final String tag;
    private final String time;
    private final String title;
    private final String updatedAt;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsUnread() {
        return this.isUnread;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSupportsPin() {
        return this.supportsPin;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getIsDeviceOnline() {
        return this.isDeviceOnline;
    }

    /* renamed from: component17, reason: from getter */
    public final String getCliType() {
        return this.cliType;
    }

    /* renamed from: component18, reason: from getter */
    public final TaskIconType getIconType() {
        return this.iconType;
    }

    /* renamed from: component19, reason: from getter */
    public final String getSearchSnippet() {
        return this.searchSnippet;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInitial() {
        return this.initial;
    }

    /* renamed from: component20, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final List<String> component21() {
        return this.searchHighlightKeywords;
    }

    /* renamed from: component22, reason: from getter */
    public final String getSearchAnchorCreatedAtMs() {
        return this.searchAnchorCreatedAtMs;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final TaskStatus getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    public final TaskModel copy(String id, String initial, String title, TaskStatus status, String tag, String location, String time, String updatedAt, String cliId, String mode, boolean isUnread, boolean isPinned, String pinnedAt, boolean supportsPin, boolean isLocal, boolean isDeviceOnline, String cliType, TaskIconType iconType, String searchSnippet, String searchQuery, List<String> searchHighlightKeywords, String searchAnchorCreatedAtMs) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(time, DBData.FIELD_TIME);
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(pinnedAt, "pinnedAt");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Intrinsics.checkNotNullParameter(searchSnippet, "searchSnippet");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        return new TaskModel(id, initial, title, status, tag, location, time, updatedAt, cliId, mode, isUnread, isPinned, pinnedAt, supportsPin, isLocal, isDeviceOnline, cliType, iconType, searchSnippet, searchQuery, searchHighlightKeywords, searchAnchorCreatedAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskModel)) {
            return false;
        }
        TaskModel taskModel = (TaskModel) other;
        return Intrinsics.areEqual(this.id, taskModel.id) && Intrinsics.areEqual(this.initial, taskModel.initial) && Intrinsics.areEqual(this.title, taskModel.title) && this.status == taskModel.status && Intrinsics.areEqual(this.tag, taskModel.tag) && Intrinsics.areEqual(this.location, taskModel.location) && Intrinsics.areEqual(this.time, taskModel.time) && Intrinsics.areEqual(this.updatedAt, taskModel.updatedAt) && Intrinsics.areEqual(this.cliId, taskModel.cliId) && Intrinsics.areEqual(this.mode, taskModel.mode) && this.isUnread == taskModel.isUnread && this.isPinned == taskModel.isPinned && Intrinsics.areEqual(this.pinnedAt, taskModel.pinnedAt) && this.supportsPin == taskModel.supportsPin && this.isLocal == taskModel.isLocal && this.isDeviceOnline == taskModel.isDeviceOnline && Intrinsics.areEqual(this.cliType, taskModel.cliType) && this.iconType == taskModel.iconType && Intrinsics.areEqual(this.searchSnippet, taskModel.searchSnippet) && Intrinsics.areEqual(this.searchQuery, taskModel.searchQuery) && Intrinsics.areEqual(this.searchHighlightKeywords, taskModel.searchHighlightKeywords) && Intrinsics.areEqual(this.searchAnchorCreatedAtMs, taskModel.searchAnchorCreatedAtMs);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.initial.hashCode()) * 31) + this.title.hashCode()) * 31) + this.status.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.location.hashCode()) * 31) + this.time.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.cliId.hashCode()) * 31) + this.mode.hashCode()) * 31) + Boolean.hashCode(this.isUnread)) * 31) + Boolean.hashCode(this.isPinned)) * 31) + this.pinnedAt.hashCode()) * 31) + Boolean.hashCode(this.supportsPin)) * 31) + Boolean.hashCode(this.isLocal)) * 31) + Boolean.hashCode(this.isDeviceOnline)) * 31;
        String str = this.cliType;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.iconType.hashCode()) * 31) + this.searchSnippet.hashCode()) * 31) + this.searchQuery.hashCode()) * 31;
        List<String> list = this.searchHighlightKeywords;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.searchAnchorCreatedAtMs;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TaskModel(id=");
        sb.append(this.id).append(", initial=").append(this.initial).append(", title=").append(this.title).append(", status=").append(this.status).append(", tag=").append(this.tag).append(", location=").append(this.location).append(", time=").append(this.time).append(", updatedAt=").append(this.updatedAt).append(", cliId=").append(this.cliId).append(", mode=").append(this.mode).append(", isUnread=").append(this.isUnread).append(", isPinned=");
        sb.append(this.isPinned).append(", pinnedAt=").append(this.pinnedAt).append(", supportsPin=").append(this.supportsPin).append(", isLocal=").append(this.isLocal).append(", isDeviceOnline=").append(this.isDeviceOnline).append(", cliType=").append(this.cliType).append(", iconType=").append(this.iconType).append(", searchSnippet=").append(this.searchSnippet).append(", searchQuery=").append(this.searchQuery).append(", searchHighlightKeywords=").append(this.searchHighlightKeywords).append(", searchAnchorCreatedAtMs=").append(this.searchAnchorCreatedAtMs).append(')');
        return sb.toString();
    }

    public TaskModel(String str, String str2, String str3, TaskStatus taskStatus, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, String str10, boolean z3, boolean z4, boolean z5, String str11, TaskIconType taskIconType, String str12, String str13, List<String> list, String str14) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "initial");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(taskStatus, PageDataManager.EXTRA_STATUS);
        Intrinsics.checkNotNullParameter(str4, "tag");
        Intrinsics.checkNotNullParameter(str5, "location");
        Intrinsics.checkNotNullParameter(str6, DBData.FIELD_TIME);
        Intrinsics.checkNotNullParameter(str7, "updatedAt");
        Intrinsics.checkNotNullParameter(str8, "cliId");
        Intrinsics.checkNotNullParameter(str9, "mode");
        Intrinsics.checkNotNullParameter(str10, "pinnedAt");
        Intrinsics.checkNotNullParameter(taskIconType, "iconType");
        Intrinsics.checkNotNullParameter(str12, "searchSnippet");
        Intrinsics.checkNotNullParameter(str13, "searchQuery");
        this.id = str;
        this.initial = str2;
        this.title = str3;
        this.status = taskStatus;
        this.tag = str4;
        this.location = str5;
        this.time = str6;
        this.updatedAt = str7;
        this.cliId = str8;
        this.mode = str9;
        this.isUnread = z;
        this.isPinned = z2;
        this.pinnedAt = str10;
        this.supportsPin = z3;
        this.isLocal = z4;
        this.isDeviceOnline = z5;
        this.cliType = str11;
        this.iconType = taskIconType;
        this.searchSnippet = str12;
        this.searchQuery = str13;
        this.searchHighlightKeywords = list;
        this.searchAnchorCreatedAtMs = str14;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInitial() {
        return this.initial;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TaskStatus getStatus() {
        return this.status;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getMode() {
        return this.mode;
    }

    public final boolean isUnread() {
        return this.isUnread;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    public final boolean getSupportsPin() {
        return this.supportsPin;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isDeviceOnline() {
        return this.isDeviceOnline;
    }

    public final String getCliType() {
        return this.cliType;
    }

    public /* synthetic */ TaskModel(String str, String str2, String str3, TaskStatus taskStatus, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, String str10, boolean z3, boolean z4, boolean z5, String str11, TaskIconType taskIconType, String str12, String str13, List list, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, taskStatus, (i & 16) != 0 ? "Cloud" : str4, str5, str6, (i & 128) != 0 ? "" : str7, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? "" : str8, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? "" : str9, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? false : z2, (i & 4096) != 0 ? "" : str10, (i & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? false : z3, (i & 16384) != 0 ? false : z4, (32768 & i) != 0 ? true : z5, (65536 & i) != 0 ? null : str11, (131072 & i) != 0 ? TaskIconType.CHAT : taskIconType, (262144 & i) != 0 ? "" : str12, (524288 & i) != 0 ? "" : str13, (1048576 & i) != 0 ? null : list, (i & 2097152) != 0 ? null : str14);
    }

    public final TaskIconType getIconType() {
        return this.iconType;
    }

    public final String getSearchSnippet() {
        return this.searchSnippet;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final List<String> getSearchHighlightKeywords() {
        return this.searchHighlightKeywords;
    }

    public final String getSearchAnchorCreatedAtMs() {
        return this.searchAnchorCreatedAtMs;
    }
}
