package com.bytedance.sdk.xbridge.cn.calendar;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXCreateCalendarEventMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XCreateCalendarEventParamModel", "XCreateCalendarEventResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXCreateCalendarEventMethodIDL extends XCoreIDLBridgeMethod<XCreateCalendarEventParamModel, XCreateCalendarEventResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "16589"));

    @XBridgeMethodName(name = "x.createCalendarEvent", params = {"identifier", "repeatFrequency", "repeatInterval", "repeatCount", "startDate", "endDate", "alarmOffset", ReducerConstants.EVENT_ALL_DAY, "title", "notes", "location", IWeixinService.ResponseConstants.URL, "calendarName"}, results = {""})
    private final String name = "x.createCalendarEvent";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXCreateCalendarEventMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XCreateCalendarEventResultModel extends XBaseResultModel {
    }

    /* compiled from: AbsXCreateCalendarEventMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXCreateCalendarEventMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    /* compiled from: AbsXCreateCalendarEventMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0016\u0010 \u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "alarmOffset", "", "getAlarmOffset", "()Ljava/lang/Number;", ReducerConstants.EVENT_ALL_DAY, "", "getAllDay", "()Ljava/lang/Boolean;", "calendarName", "", "getCalendarName", "()Ljava/lang/String;", "endDate", "getEndDate", "identifier", "getIdentifier", "location", "getLocation", "notes", "getNotes", "repeatCount", "getRepeatCount", "repeatFrequency", "getRepeatFrequency", "repeatInterval", "getRepeatInterval", "startDate", "getStartDate", "title", "getTitle", IWeixinService.ResponseConstants.URL, "getUrl", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XCreateCalendarEventParamModel extends XBaseParamModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XCreateCalendarEventRepeatFrequencyDAILY = "DAILY";
        public static final String XCreateCalendarEventRepeatFrequencyDaily = "daily";
        public static final String XCreateCalendarEventRepeatFrequencyMONTHLY = "MONTHLY";
        public static final String XCreateCalendarEventRepeatFrequencyMonthly = "monthly";
        public static final String XCreateCalendarEventRepeatFrequencyWEEKLY = "WEEKLY";
        public static final String XCreateCalendarEventRepeatFrequencyWeekly = "weekly";
        public static final String XCreateCalendarEventRepeatFrequencyYEARLY = "YEARLY";
        public static final String XCreateCalendarEventRepeatFrequencyYearly = "yearly";

        @XBridgeParamField(isGetter = true, keyPath = "alarmOffset", required = false)
        Number getAlarmOffset();

        @XBridgeParamField(isGetter = true, keyPath = ReducerConstants.EVENT_ALL_DAY, required = false)
        Boolean getAllDay();

        @XBridgeParamField(isGetter = true, keyPath = "calendarName", required = false)
        String getCalendarName();

        @XBridgeParamField(isGetter = true, keyPath = "endDate", required = true)
        Number getEndDate();

        @XBridgeParamField(isGetter = true, keyPath = "identifier", required = true)
        String getIdentifier();

        @XBridgeParamField(isGetter = true, keyPath = "location", required = false)
        String getLocation();

        @XBridgeParamField(isGetter = true, keyPath = "notes", required = false)
        String getNotes();

        @XBridgeParamField(isGetter = true, keyPath = "repeatCount", required = true)
        Number getRepeatCount();

        @XBridgeStringEnum(option = {"DAILY", "MONTHLY", "WEEKLY", "YEARLY", "daily", "monthly", "weekly", "yearly"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "repeatFrequency", required = true)
        String getRepeatFrequency();

        @XBridgeParamField(isGetter = true, keyPath = "repeatInterval", required = true)
        Number getRepeatInterval();

        @XBridgeParamField(isGetter = true, keyPath = "startDate", required = true)
        Number getStartDate();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = IWeixinService.ResponseConstants.URL, required = false)
        String getUrl();

        /* compiled from: AbsXCreateCalendarEventMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel$Companion;", "", "()V", "XCreateCalendarEventRepeatFrequencyDAILY", "", "XCreateCalendarEventRepeatFrequencyDaily", "XCreateCalendarEventRepeatFrequencyMONTHLY", "XCreateCalendarEventRepeatFrequencyMonthly", "XCreateCalendarEventRepeatFrequencyWEEKLY", "XCreateCalendarEventRepeatFrequencyWeekly", "XCreateCalendarEventRepeatFrequencyYEARLY", "XCreateCalendarEventRepeatFrequencyYearly", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XCreateCalendarEventRepeatFrequencyDAILY = "DAILY";
            public static final String XCreateCalendarEventRepeatFrequencyDaily = "daily";
            public static final String XCreateCalendarEventRepeatFrequencyMONTHLY = "MONTHLY";
            public static final String XCreateCalendarEventRepeatFrequencyMonthly = "monthly";
            public static final String XCreateCalendarEventRepeatFrequencyWEEKLY = "WEEKLY";
            public static final String XCreateCalendarEventRepeatFrequencyWeekly = "weekly";
            public static final String XCreateCalendarEventRepeatFrequencyYEARLY = "YEARLY";
            public static final String XCreateCalendarEventRepeatFrequencyYearly = "yearly";

            private Companion() {
            }
        }
    }
}
