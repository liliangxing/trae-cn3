package com.bytedance.iesgurd.statistic.model;

import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventMessageModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\t\u0010\u0011\u001a\u00020\nHÂ\u0003JM\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/EventMessageModel;", "", "subType", "Lcom/bytedance/iesgurd/core/EventSubType;", "accessKey", "", "channels", "errMsg", "extra", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "(Lcom/bytedance/iesgurd/core/EventSubType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "upload", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class EventMessageModel {
    private final String accessKey;
    private final String channels;
    private final long duration;
    private final String errMsg;
    private final String extra;
    private final EventSubType subType;

    /* renamed from: component1, reason: from getter */
    private final EventSubType getSubType() {
        return this.subType;
    }

    /* renamed from: component2, reason: from getter */
    private final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component3, reason: from getter */
    private final String getChannels() {
        return this.channels;
    }

    /* renamed from: component4, reason: from getter */
    private final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: component5, reason: from getter */
    private final String getExtra() {
        return this.extra;
    }

    /* renamed from: component6, reason: from getter */
    private final long getDuration() {
        return this.duration;
    }

    public static /* synthetic */ EventMessageModel copy$default(EventMessageModel eventMessageModel, EventSubType eventSubType, String str, String str2, String str3, String str4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            eventSubType = eventMessageModel.subType;
        }
        if ((i & 2) != 0) {
            str = eventMessageModel.accessKey;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = eventMessageModel.channels;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = eventMessageModel.errMsg;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = eventMessageModel.extra;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            j = eventMessageModel.duration;
        }
        return eventMessageModel.copy(eventSubType, str5, str6, str7, str8, j);
    }

    public final EventMessageModel copy(EventSubType subType, String accessKey, String channels, String errMsg, String extra, long duration) {
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        return new EventMessageModel(subType, accessKey, channels, errMsg, extra, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventMessageModel)) {
            return false;
        }
        EventMessageModel eventMessageModel = (EventMessageModel) other;
        return Intrinsics.areEqual(this.subType, eventMessageModel.subType) && Intrinsics.areEqual(this.accessKey, eventMessageModel.accessKey) && Intrinsics.areEqual(this.channels, eventMessageModel.channels) && Intrinsics.areEqual(this.errMsg, eventMessageModel.errMsg) && Intrinsics.areEqual(this.extra, eventMessageModel.extra) && this.duration == eventMessageModel.duration;
    }

    public int hashCode() {
        EventSubType eventSubType = this.subType;
        int hashCode = (eventSubType != null ? eventSubType.hashCode() : 0) * 31;
        String str = this.accessKey;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channels;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.errMsg;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.extra;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        long j = this.duration;
        return hashCode5 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "EventMessageModel(subType=" + this.subType + ", accessKey=" + this.accessKey + ", channels=" + this.channels + ", errMsg=" + this.errMsg + ", extra=" + this.extra + ", duration=" + this.duration + ")";
    }

    public EventMessageModel(EventSubType eventSubType, String str, String str2, String str3, String str4, long j) {
        Intrinsics.checkParameterIsNotNull(eventSubType, "subType");
        this.subType = eventSubType;
        this.accessKey = str;
        this.channels = str2;
        this.errMsg = str3;
        this.extra = str4;
        this.duration = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ EventMessageModel(EventSubType eventSubType, String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventSubType, r0, r2, r3, r1, (i & 32) != 0 ? 0L : j);
        String str5;
        String str6;
        String str7;
        String str8 = null;
        if ((i & 2) != 0) {
            str5 = null;
        } else {
            str5 = str;
        }
        if ((i & 4) != 0) {
            str6 = null;
        } else {
            str6 = str2;
        }
        if ((i & 8) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i & 16) != 0) {
        } else {
            str8 = str4;
        }
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sub_type", this.subType.getType());
        String str = this.accessKey;
        if (str != null) {
            jSONObject.put("access_key", str);
        }
        String str2 = this.channels;
        if (str2 != null) {
            jSONObject.put("channels", str2);
        }
        String str3 = this.errMsg;
        if (str3 != null) {
            jSONObject.put("err_msg", str3);
        }
        String str4 = this.extra;
        if (str4 != null) {
            jSONObject.put("extra", str4);
        }
        long j = this.duration;
        if (j != 0) {
            jSONObject.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, j);
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_event_message", jSONObject);
    }
}
