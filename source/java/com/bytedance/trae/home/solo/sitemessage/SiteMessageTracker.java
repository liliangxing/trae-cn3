package com.bytedance.trae.home.solo.sitemessage;

import android.util.Log;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SiteMessageTracker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0016J*\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00052\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000e0%¢\u0006\u0002\b'H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;", "", "<init>", "()V", "TAG", "", "EVENT_LIST_PAGE_VIEW", "EVENT_ITEM_CLICK", "EVENT_ITEM_DELETE", "EVENT_CTA_CLICK", "EVENT_SETTINGS_PAGE_VIEW", "EVENT_SETTINGS_TOGGLE", "EVENT_ENTRY_CLICK", "trackListPageView", "", "itemCount", "", "unreadCount", "trackItemClick", "messageId", "messageType", "isRead", "", NewTaskTracker.Param.POSITION, "trackItemDelete", "trackCtaClick", "buttonLabel", IWeixinService.ResponseConstants.URL, "trackSettingsPageView", "trackSettingsToggle", "key", "enabled", "trackEntryClick", "hasUnread", "report", Fields.EVENT, "buildParams", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ExtensionFunctionType;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageTracker {
    public static final int $stable = 0;
    private static final String EVENT_CTA_CLICK = "icube_notification_cta_click";
    private static final String EVENT_ENTRY_CLICK = "icube_notification_entry_click";
    private static final String EVENT_ITEM_CLICK = "icube_notification_item_click";
    private static final String EVENT_ITEM_DELETE = "icube_notification_item_delete";
    private static final String EVENT_LIST_PAGE_VIEW = "icube_notification_list_page_view";
    private static final String EVENT_SETTINGS_PAGE_VIEW = "icube_notification_settings_page_view";
    private static final String EVENT_SETTINGS_TOGGLE = "icube_notification_settings_toggle";
    public static final SiteMessageTracker INSTANCE = new SiteMessageTracker();
    private static final String TAG = "SiteMessageTracker";

    private SiteMessageTracker() {
    }

    private final void report(String event, Function1<? super JSONObject, Unit> buildParams) {
        JSONObject jSONObject = new JSONObject();
        buildParams.invoke(jSONObject);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: " + event + ", params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(event, jSONObject);
    }

    public final void trackListPageView(int itemCount, int unreadCount) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_count", itemCount);
        jSONObject.put("unread_count", unreadCount);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_list_page_view, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_LIST_PAGE_VIEW, jSONObject);
    }

    public final void trackItemClick(int messageId, String messageType, boolean isRead, int position) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message_id", messageId);
        jSONObject.put("message_type", messageType);
        jSONObject.put("is_read", isRead);
        jSONObject.put(NewTaskTracker.Param.POSITION, position);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_item_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_ITEM_CLICK, jSONObject);
    }

    public final void trackItemDelete(int messageId, int position) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message_id", messageId);
        jSONObject.put(NewTaskTracker.Param.POSITION, position);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_item_delete, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_ITEM_DELETE, jSONObject);
    }

    public final void trackCtaClick(int messageId, String buttonLabel, String url) {
        Intrinsics.checkNotNullParameter(buttonLabel, "buttonLabel");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message_id", messageId);
        jSONObject.put("button_label", buttonLabel);
        jSONObject.put(IWeixinService.ResponseConstants.URL, url);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_cta_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_CTA_CLICK, jSONObject);
    }

    public final void trackSettingsPageView() {
        JSONObject jSONObject = new JSONObject();
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_settings_page_view, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_SETTINGS_PAGE_VIEW, jSONObject);
    }

    public final void trackSettingsToggle(String key, boolean enabled) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", key);
        jSONObject.put("enabled", enabled);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_settings_toggle, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_SETTINGS_TOGGLE, jSONObject);
    }

    public final void trackEntryClick(boolean hasUnread) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("has_unread", hasUnread);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_notification_entry_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_ENTRY_CLICK, jSONObject);
    }
}
