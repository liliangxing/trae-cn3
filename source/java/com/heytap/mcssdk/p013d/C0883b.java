package com.heytap.mcssdk.p013d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.C0880c;
import com.heytap.mcssdk.constant.C0881d;
import com.heytap.mcssdk.p016g.C0891a;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.heytap.mcssdk.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0883b {

    /* renamed from: c */
    private int f601c;

    /* renamed from: d */
    private int f602d;

    /* renamed from: f */
    private int f604f;

    /* renamed from: g */
    private int f605g;

    /* renamed from: h */
    private StatusBarNotification f606h;

    /* renamed from: a */
    private int f599a = 3;

    /* renamed from: b */
    private List<NotificationSortMessage> f600b = new ArrayList();

    /* renamed from: e */
    private List<String> f603e = new ArrayList();

    /* renamed from: com.heytap.mcssdk.d.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class a {

        /* renamed from: a */
        private static final C0883b f607a = new C0883b();

        private a() {
        }
    }

    /* renamed from: a */
    private int m611a(List<NotificationSortMessage> list, int i) {
        int size = list == null ? 0 : list.size();
        if (i <= 0 || size == 0) {
            return i;
        }
        if (size < i) {
            int i2 = i - size;
            list.clear();
            return i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            list.remove((size - 1) - i3);
        }
        return 0;
    }

    /* renamed from: a */
    public static C0883b m612a() {
        return a.f607a;
    }

    /* renamed from: a */
    private DataMessage m613a(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C0881d.b.f590a, "false");
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(C0881d.b.f591b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    /* renamed from: a */
    private void m614a(int i) {
        if (i == 7) {
            this.f601c++;
        } else if (i == 5) {
            this.f602d++;
        }
    }

    /* renamed from: a */
    private void m615a(NotificationManager notificationManager, Context context, int i) {
        m622a(C0882a.m610a(notificationManager, context.getPackageName()), i);
    }

    /* renamed from: a */
    private void m616a(Context context, NotificationManager notificationManager, int i) {
        m611a(this.f600b, i);
        m617a(context, notificationManager, this.f600b);
    }

    /* renamed from: a */
    private void m617a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        m618a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(C0881d.b.f592c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(C0880c.a.f586d, arrayList);
            StatisticUtils.statisticEvent(context, hashMap);
        }
    }

    /* renamed from: a */
    private void m618a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            } else {
                list2.add(m613a(context, notificationSortMessage));
                this.f603e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    /* renamed from: a */
    private void m619a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.f600b.size() != 0) {
            for (int size = this.f600b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.f600b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.f600b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.f600b.add(0, notificationSortMessage);
    }

    /* renamed from: a */
    private void m620a(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.f603e);
        }
    }

    /* renamed from: a */
    private void m621a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        builder.addExtras(bundle);
        builder.setGroup(notificationSortMessage.getGroup());
    }

    /* renamed from: a */
    private void m622a(StatusBarNotification[] statusBarNotificationArr, int i) {
        m627b();
        if (statusBarNotificationArr != null && statusBarNotificationArr.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                boolean z = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
                long j = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
                String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
                int i2 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
                int i3 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
                String string2 = bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
                int id = statusBarNotification.getId();
                if (i == id) {
                    this.f606h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i3, i2, z, j, id, string2);
                m628b(i2);
                m614a(i3);
                m619a(notificationSortMessage);
            }
        }
        if (C0895d.m681g()) {
            C0895d.m661b("initParams : notDelete:" + this.f605g + " canDelete : " + this.f604f + "\n highSize : " + this.f601c + " normalSize :" + this.f602d + '\n');
            C0895d.m661b("canDeleteList size : " + this.f600b.size());
            for (int i4 = 0; i4 < this.f600b.size(); i4++) {
                NotificationSortMessage notificationSortMessage2 = this.f600b.get(i4);
                C0895d.m661b("第" + i4 + "条消息 messageId : " + notificationSortMessage2.getMessageId() + " importanceLevel : " + notificationSortMessage2.getImportantLevel() + " autoDelete : " + notificationSortMessage2.getAutoDelete() + " notifyId: " + notificationSortMessage2.getNotifyId() + " postTime:" + notificationSortMessage2.getPostTime());
            }
        }
    }

    /* renamed from: a */
    private boolean m623a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        if (C0895d.m681g()) {
            C0895d.m661b("dealCurrentMessage : deleteNumber" + (this.f604f + this.f605g) + " keepNumber : " + this.f599a);
        }
        boolean z = true;
        if (this.f604f + this.f605g < this.f599a) {
            notificationSortMessage.setGroup((notificationSortMessage.getAutoDelete() == -1 ? new StringBuilder(C0881d.a.f588b) : new StringBuilder(C0881d.a.f589c)).append(context.getPackageName()).toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(C0881d.a.f588b + context.getPackageName());
            int i = this.f599a - this.f605g;
            if (C0895d.m681g()) {
                C0895d.m661b("dealCurrentMessage : allowDelete :" + i);
            }
            if (i > 0) {
                m616a(context, notificationManager, i - 1);
            } else {
                Notification m606a = C0882a.m606a(context, notificationSortMessage.getGroup(), builder);
                if (m606a != null) {
                    notificationManager.notify(4096, m606a);
                }
            }
        } else {
            z = m624a(context, notificationManager, notificationSortMessage);
        }
        if (C0895d.m681g()) {
            C0895d.m661b("dealCurrentMessage : needPost :" + z);
        }
        if (z) {
            m621a(builder, notificationSortMessage);
        } else {
            C0891a.m643a(context, C0880c.a.f585c, m613a(context, notificationSortMessage));
        }
        return z;
    }

    /* renamed from: a */
    private boolean m624a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i = this.f605g;
        int i2 = this.f599a;
        boolean z = false;
        if (i >= i2) {
            return false;
        }
        int i3 = i2 - i;
        if (C0895d.m681g()) {
            C0895d.m661b("judgeShowCurrentMessage : allowDelete" + i3);
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.f601c + this.f602d < i3 : this.f601c < i3)) {
            z = true;
        }
        if (z) {
            m616a(context, notificationManager, i3 - 1);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m625a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.f606h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        notificationSortMessage.setGroup((notificationSortMessage.getAutoDelete() == 1 ? new StringBuilder(C0881d.a.f589c) : new StringBuilder(C0881d.a.f588b)).append(context.getPackageName()).toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        m621a(builder, notificationSortMessage);
        this.f603e.add(string);
        return true;
    }

    /* renamed from: a */
    private boolean m626a(PushNotification.Builder builder, int i, int i2, String str, String str2) {
        Context context = PushService.getInstance().getContext();
        if (builder == null || context == null) {
            return false;
        }
        NotificationManager m607a = C0882a.m607a(context);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i2, i, false, System.currentTimeMillis(), str2);
        if (!m630a(context, m607a, notificationSortMessage, builder)) {
            return true;
        }
        m615a(m607a, context, builder.getVerifyNotifyId());
        if (m625a(context, builder, notificationSortMessage)) {
            return true;
        }
        return m623a(m607a, context, builder, notificationSortMessage);
    }

    /* renamed from: b */
    private void m627b() {
        this.f604f = 0;
        this.f605g = 0;
        this.f601c = 0;
        this.f602d = 0;
        this.f600b.clear();
        this.f603e.clear();
        this.f606h = null;
    }

    /* renamed from: b */
    private void m628b(int i) {
        if (i == -1) {
            this.f605g++;
        } else if (i == 1) {
            this.f604f++;
        }
    }

    /* renamed from: a */
    public void m629a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        m620a(iSortListener, m626a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    /* renamed from: a */
    public boolean m630a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        if (notificationSortMessage.getAutoDelete() == 0 || Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        if (!C0882a.m609a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(C0881d.a.f588b + context.getPackageName());
        m621a(builder, notificationSortMessage);
        return false;
    }
}
