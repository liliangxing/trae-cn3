package com.bytedance.android.monitorV2.settings;

import com.bytedance.android.monitorV2.util.JsonToStringAdapter;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.open.douyin.settings.f;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/Data;", "", "settings", "", "vidInfo", "ctxInfos", "settingsTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getCtxInfos", "()Ljava/lang/String;", WebViewContainer.EVENT_getSettings, "getSettingsTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVidInfo", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/monitorV2/settings/Data;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Data {

    @SerializedName("ctx_infos")
    private final String ctxInfos;

    @SerializedName("settings")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String settings;

    @SerializedName("settings_time")
    private final Long settingsTime;

    @SerializedName(f.g)
    @JsonAdapter(JsonToStringAdapter.class)
    private final String vidInfo;

    public Data() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.settings;
        }
        if ((i & 2) != 0) {
            str2 = data.vidInfo;
        }
        if ((i & 4) != 0) {
            str3 = data.ctxInfos;
        }
        if ((i & 8) != 0) {
            l = data.settingsTime;
        }
        return data.copy(str, str2, str3, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSettings() {
        return this.settings;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVidInfo() {
        return this.vidInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCtxInfos() {
        return this.ctxInfos;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getSettingsTime() {
        return this.settingsTime;
    }

    public final Data copy(String settings, String vidInfo, String ctxInfos, Long settingsTime) {
        return new Data(settings, vidInfo, ctxInfos, settingsTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.settings, data.settings) && Intrinsics.areEqual(this.vidInfo, data.vidInfo) && Intrinsics.areEqual(this.ctxInfos, data.ctxInfos) && Intrinsics.areEqual(this.settingsTime, data.settingsTime);
    }

    public int hashCode() {
        String str = this.settings;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vidInfo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ctxInfos;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.settingsTime;
        return hashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "Data(settings=" + this.settings + ", vidInfo=" + this.vidInfo + ", ctxInfos=" + this.ctxInfos + ", settingsTime=" + this.settingsTime + ')';
    }

    public Data(String str, String str2, String str3, Long l) {
        this.settings = str;
        this.vidInfo = str2;
        this.ctxInfos = str3;
        this.settingsTime = l;
    }

    public /* synthetic */ Data(String str, String str2, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l);
    }

    public final String getSettings() {
        return this.settings;
    }

    public final String getVidInfo() {
        return this.vidInfo;
    }

    public final String getCtxInfos() {
        return this.ctxInfos;
    }

    public final Long getSettingsTime() {
        return this.settingsTime;
    }
}
