package com.bytedance.push.model;

import android.app.NotificationChannel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PushNotificationChannel {
    private boolean bypassDnd;
    private JSONObject channelFields;
    private String desc;
    private boolean enable;
    private String id;
    private int importance;
    private boolean lights;
    private int lockscreenVisibility;
    private String name;
    private boolean showBadge;
    private String sound;
    private boolean vibration;

    public PushNotificationChannel(JSONObject jSONObject) {
        this.enable = true;
        this.id = jSONObject.optString("id");
        this.name = jSONObject.optString("name");
        this.importance = jSONObject.optInt("importance", 3);
        this.bypassDnd = jSONObject.optBoolean("bypassDnd", true);
        this.lockscreenVisibility = jSONObject.optInt("lockscreenVisibility", -1);
        this.lights = jSONObject.optBoolean("lights", true);
        this.vibration = jSONObject.optBoolean("vibration", true);
        this.showBadge = jSONObject.optBoolean("showBadge", true);
        this.enable = jSONObject.optBoolean("enable", true);
        this.desc = jSONObject.optString("desc");
        this.sound = jSONObject.optString(RemoteMessageConst.Notification.SOUND);
        JSONObject optJSONObject = jSONObject.optJSONObject("channel_fields");
        this.channelFields = optJSONObject;
        if (optJSONObject == null) {
            this.channelFields = new JSONObject();
        }
    }

    public PushNotificationChannel(NotificationChannel notificationChannel) {
        this.enable = true;
        this.id = notificationChannel.getId();
        this.name = String.valueOf(notificationChannel.getName());
        this.importance = notificationChannel.getImportance();
        this.bypassDnd = notificationChannel.canBypassDnd();
        this.lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        this.lights = notificationChannel.shouldShowLights();
        this.vibration = notificationChannel.shouldVibrate();
        this.showBadge = notificationChannel.canShowBadge();
        this.desc = notificationChannel.getDescription();
        this.channelFields = new JSONObject();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", getId());
        jSONObject.put("name", getName());
        jSONObject.put("importance", getImportance());
        jSONObject.put("bypassDnd", canBypassDnd());
        jSONObject.put("lockscreenVisibility", getLockscreenVisibility());
        jSONObject.put("lights", shouldShowLights());
        jSONObject.put("vibration", shouldVibrate());
        jSONObject.put("showBadge", isShowBadge());
        jSONObject.put("enable", isEnable());
        jSONObject.put("desc", getDesc());
        jSONObject.put("channel_fields", getChannelFields());
        return jSONObject;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getImportance() {
        return this.importance;
    }

    public void setImportance(int i) {
        this.importance = i;
    }

    public int getLockscreenVisibility() {
        return this.lockscreenVisibility;
    }

    public void setLockscreenVisibility(int i) {
        this.lockscreenVisibility = i;
    }

    public boolean canBypassDnd() {
        return this.bypassDnd;
    }

    public void setBypassDnd(boolean z) {
        this.bypassDnd = z;
    }

    public boolean shouldShowLights() {
        return this.lights;
    }

    public void setLights(boolean z) {
        this.lights = z;
    }

    public boolean shouldVibrate() {
        return this.vibration;
    }

    public void setVibration(boolean z) {
        this.vibration = z;
    }

    public boolean isShowBadge() {
        return this.showBadge;
    }

    public void setShowBadge(boolean z) {
        this.showBadge = z;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getSound() {
        return this.sound;
    }

    public PushNotificationChannel setSound(String str) {
        this.sound = str;
        return this;
    }

    public JSONObject getChannelFields() {
        return this.channelFields;
    }
}
