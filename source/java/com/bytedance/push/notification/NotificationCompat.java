package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.model.PushNotificationChannel;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.CustomSoundUtils;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.ss.android.message.util.ToolUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class NotificationCompat {
    private static final String TAG = "NotificationCompat";
    private static Impl sNotificationService;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    interface Impl {
        void createChannel(Context context, PushNotificationChannel pushNotificationChannel);

        void deleteChannel(Context context, PushNotificationChannel pushNotificationChannel);

        JSONArray getNotificationChannels(Context context);

        boolean isSwitcherChanged(Context context, int i);
    }

    NotificationCompat() {
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            sNotificationService = new OImpl();
        } else {
            sNotificationService = new BaseImpl();
        }
    }

    public static Impl get() {
        return sNotificationService;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class BaseImpl implements Impl {
        private NotificationManager manager;

        @Override // com.bytedance.push.notification.NotificationCompat.Impl
        public void deleteChannel(Context context, PushNotificationChannel pushNotificationChannel) {
        }

        private BaseImpl() {
            this.manager = null;
        }

        @Override // com.bytedance.push.notification.NotificationCompat.Impl
        public boolean isSwitcherChanged(Context context, int i) {
            return ToolUtils.areNotificationsEnabled(context) != i;
        }

        @Override // com.bytedance.push.notification.NotificationCompat.Impl
        public JSONArray getNotificationChannels(Context context) {
            return new JSONArray();
        }

        @Override // com.bytedance.push.notification.NotificationCompat.Impl
        public void createChannel(Context context, PushNotificationChannel pushNotificationChannel) {
            Configuration configuration = PushSupporter.get().getConfiguration();
            CustomSoundUtils.downLoadCustomSound(context, configuration != null ? configuration.mAsyncSoundDownloaderWrapper : null, pushNotificationChannel.getSound(), pushNotificationChannel.getId(), null);
        }

        NotificationManager getNotificationManager(Context context) {
            if (this.manager == null) {
                this.manager = (NotificationManager) context.getSystemService("notification");
            }
            return this.manager;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class OImpl extends BaseImpl {
        private List<NotificationChannel> sChannels;

        private OImpl() {
            super();
        }

        @Override // com.bytedance.push.notification.NotificationCompat.BaseImpl, com.bytedance.push.notification.NotificationCompat.Impl
        public void deleteChannel(Context context, PushNotificationChannel pushNotificationChannel) {
            NotificationManager notificationManager;
            if (pushNotificationChannel == null || (notificationManager = getNotificationManager(context)) == null || TextUtils.isEmpty(pushNotificationChannel.getId()) || notificationManager.getNotificationChannel(pushNotificationChannel.getId()) == null) {
                return;
            }
            notificationManager.deleteNotificationChannel(pushNotificationChannel.getId());
        }

        @Override // com.bytedance.push.notification.NotificationCompat.BaseImpl, com.bytedance.push.notification.NotificationCompat.Impl
        public void createChannel(Context context, PushNotificationChannel pushNotificationChannel) {
            NotificationManager notificationManager;
            if (pushNotificationChannel == null || (notificationManager = getNotificationManager(context)) == null || TextUtils.isEmpty(pushNotificationChannel.getId()) || TextUtils.isEmpty(pushNotificationChannel.getName()) || notificationManager.getNotificationChannel(pushNotificationChannel.getId()) != null) {
                return;
            }
            int importance = pushNotificationChannel.getImportance();
            if (importance < 0 || importance > 5) {
                importance = 3;
            }
            NotificationChannel notificationChannel = new NotificationChannel(pushNotificationChannel.getId(), pushNotificationChannel.getName(), importance);
            notificationChannel.setShowBadge(pushNotificationChannel.isShowBadge());
            notificationChannel.setDescription(pushNotificationChannel.getDesc());
            notificationChannel.enableVibration(pushNotificationChannel.shouldVibrate());
            notificationChannel.setBypassDnd(pushNotificationChannel.canBypassDnd());
            notificationChannel.enableLights(pushNotificationChannel.shouldShowLights());
            notificationChannel.setLockscreenVisibility(pushNotificationChannel.getLockscreenVisibility());
            Iterator<String> keys = pushNotificationChannel.getChannelFields().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = pushNotificationChannel.getChannelFields().opt(next);
                if (opt != null) {
                    DoubleReflectUtils.setFieldValue(notificationChannel, next, opt);
                }
            }
            if (createChannelWithSoundInternal(context, notificationManager, notificationChannel, pushNotificationChannel.getSound())) {
                return;
            }
            createChannel(notificationManager, notificationChannel);
        }

        public boolean createChannelWithSoundInternal(final Context context, final NotificationManager notificationManager, final NotificationChannel notificationChannel, String str) {
            Configuration configuration = PushSupporter.get().getConfiguration();
            if (CustomSoundUtils.downLoadCustomSound(context, configuration != null ? configuration.mAsyncSoundDownloaderWrapper : null, str, notificationChannel.getId(), new SoundDownloadCallback() { // from class: com.bytedance.push.notification.NotificationCompat.OImpl.1
                @Override // com.bytedance.push.notification.SoundDownloadCallback
                public void onSuccess(String str2) {
                    notificationChannel.setSound(CustomSoundUtils.getRemoteSoundUri(context, str2), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    OImpl.this.createChannel(notificationManager, notificationChannel);
                }

                @Override // com.bytedance.push.notification.SoundDownloadCallback
                public void onFailed() {
                    OImpl.this.createChannel(notificationManager, notificationChannel);
                }
            })) {
                return true;
            }
            if (configuration == null) {
                return false;
            }
            int localSoundResourceId = CustomSoundUtils.getLocalSoundResourceId(notificationChannel.getId(), configuration.mNotificationSoundsRes, str);
            if (localSoundResourceId == -1) {
                return false;
            }
            notificationChannel.setSound(CustomSoundUtils.getLocalSoundUri(context, localSoundResourceId), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            createChannel(notificationManager, notificationChannel);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createChannel(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            try {
                notificationManager.createNotificationChannel(notificationChannel);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.push.notification.NotificationCompat.BaseImpl, com.bytedance.push.notification.NotificationCompat.Impl
        public JSONArray getNotificationChannels(Context context) {
            return serializeNotificationChannelsToJson(getAllChannels(context));
        }

        @Override // com.bytedance.push.notification.NotificationCompat.BaseImpl, com.bytedance.push.notification.NotificationCompat.Impl
        public boolean isSwitcherChanged(Context context, int i) {
            if (super.isSwitcherChanged(context, i)) {
                return true;
            }
            return checkNotificationChannelChanged(context);
        }

        private List<NotificationChannel> getAllChannels(Context context) {
            List<NotificationChannel> list = this.sChannels;
            if (list == null || list.isEmpty()) {
                try {
                    this.sChannels = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannels();
                } catch (Throwable th) {
                    th.printStackTrace();
                    this.sChannels = Collections.emptyList();
                }
            }
            return this.sChannels;
        }

        private static JSONArray serializeNotificationChannelsToJson(List<NotificationChannel> list) {
            JSONArray jSONArray = new JSONArray();
            if (list == null) {
                return jSONArray;
            }
            Iterator<NotificationChannel> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(new PushNotificationChannel(it.next()).toJson());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONArray;
        }

        private boolean checkNotificationChannelChanged(Context context) {
            try {
                List<NotificationChannel> allChannels = getAllChannels(context);
                if (TextUtils.isEmpty(((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).getLastNotificationChannelStatus())) {
                    return (allChannels == null || allChannels.isEmpty()) ? false : true;
                }
                return !isTheSameNotificationChannels(allChannels, parseToNotificationChannels(new JSONArray(r5)));
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }

        private static Map<String, PushNotificationChannel> parseToNotificationChannels(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), new PushNotificationChannel(optJSONObject));
            }
            return hashMap;
        }

        private static boolean isTheSameNotificationChannels(List<NotificationChannel> list, Map<String, PushNotificationChannel> map) {
            if (list.size() != map.size()) {
                return false;
            }
            for (NotificationChannel notificationChannel : list) {
                PushNotificationChannel pushNotificationChannel = map.get(notificationChannel.getId());
                if (pushNotificationChannel == null || pushNotificationChannel.getImportance() != notificationChannel.getImportance() || pushNotificationChannel.getLockscreenVisibility() != notificationChannel.getLockscreenVisibility() || pushNotificationChannel.canBypassDnd() != notificationChannel.canBypassDnd() || pushNotificationChannel.shouldShowLights() != notificationChannel.shouldShowLights() || pushNotificationChannel.shouldVibrate() != notificationChannel.shouldVibrate()) {
                    return false;
                }
            }
            return true;
        }
    }
}
