package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestSettingsConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/ForestSettingsConfig;", "", "()V", "allowListLynx", "", "", "getAllowListLynx", "()Ljava/util/List;", "setAllowListLynx", "(Ljava/util/List;)V", "allowListWeb", "getAllowListWeb", "setAllowListWeb", "bufferMode", "getBufferMode", "()Ljava/lang/String;", "setBufferMode", "(Ljava/lang/String;)V", "disallowListLynx", "getDisallowListLynx", "setDisallowListLynx", "disallowListWeb", "getDisallowListWeb", "setDisallowListWeb", "enableSession", "", "getEnableSession", "()Ljava/lang/Boolean;", "setEnableSession", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestSettingsConfig {

    @SerializedName("disallow_list_web")
    private List<String> disallowListWeb = CollectionsKt.emptyList();

    @SerializedName("disallow_list_lynx")
    private List<String> disallowListLynx = CollectionsKt.emptyList();

    @SerializedName("allow_list_web")
    private List<String> allowListWeb = CollectionsKt.emptyList();

    @SerializedName("allow_list_lynx")
    private List<String> allowListLynx = CollectionsKt.emptyList();

    @SerializedName("enable_session")
    private Boolean enableSession = true;

    @SerializedName("buffer_mode")
    private String bufferMode = "normal";

    public final List<String> getDisallowListWeb() {
        return this.disallowListWeb;
    }

    public final void setDisallowListWeb(List<String> list) {
        this.disallowListWeb = list;
    }

    public final List<String> getDisallowListLynx() {
        return this.disallowListLynx;
    }

    public final void setDisallowListLynx(List<String> list) {
        this.disallowListLynx = list;
    }

    public final List<String> getAllowListWeb() {
        return this.allowListWeb;
    }

    public final void setAllowListWeb(List<String> list) {
        this.allowListWeb = list;
    }

    public final List<String> getAllowListLynx() {
        return this.allowListLynx;
    }

    public final void setAllowListLynx(List<String> list) {
        this.allowListLynx = list;
    }

    public final Boolean getEnableSession() {
        return this.enableSession;
    }

    public final void setEnableSession(Boolean bool) {
        this.enableSession = bool;
    }

    public final String getBufferMode() {
        return this.bufferMode;
    }

    public final void setBufferMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bufferMode = str;
    }
}
