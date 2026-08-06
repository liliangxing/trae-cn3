package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c */
    private static final String[] f1639c;

    /* renamed from: d */
    private static final int[] f1640d;

    /* renamed from: e */
    private static final long[] f1641e;

    /* renamed from: f */
    private static final HashMap<String, Object> f1642f;

    /* renamed from: g */
    private static final HashMap<String, Object> f1643g;

    /* renamed from: h */
    private static final HashMap<String, Object> f1644h;

    /* renamed from: i */
    private static final HashMap<String, Object> f1645i;

    /* renamed from: j */
    private static final HashMap<String, Object> f1646j;

    /* renamed from: a */
    private Bundle f1647a;

    /* renamed from: b */
    private Notification f1648b;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Builder {

        /* renamed from: a */
        private final Bundle f1649a;

        /* renamed from: b */
        private final Map<String, String> f1650b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f1649a = bundle;
            this.f1650b = new HashMap();
            bundle.putString(RemoteMessageConst.f1682TO, str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f1650b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f1650b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f1649a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(RemoteMessageConst.TTL, this.f1649a.getInt(RemoteMessageConst.TTL));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f1649a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f1649a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put(RemoteMessageConst.MSGID, this.f1649a.getString(RemoteMessageConst.MSGID));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(C1223m.f1692a));
                    bundle.putString(RemoteMessageConst.f1682TO, this.f1649a.getString(RemoteMessageConst.f1682TO));
                    bundle.putString(RemoteMessageConst.MSGTYPE, this.f1649a.getString(RemoteMessageConst.MSGTYPE));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.m2121w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.m2121w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f1650b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f1649a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f1650b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f1650b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f1649a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f1649a.putString(RemoteMessageConst.MSGTYPE, str);
            return this;
        }

        public Builder setReceiptMode(int i) {
            if (i != 1 && i != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f1649a.putInt(RemoteMessageConst.RECEIPT_MODE, i);
            return this;
        }

        public Builder setSendMode(int i) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f1649a.putInt(RemoteMessageConst.SEND_MODE, i);
            return this;
        }

        public Builder setTtl(int i) {
            if (i >= 1 && i <= 1296000) {
                this.f1649a.putInt(RemoteMessageConst.TTL, i);
                return this;
            }
            throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public @interface MessagePriority {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Notification implements Serializable {

        /* renamed from: A */
        private final long[] f1651A;

        /* renamed from: B */
        private final String f1652B;

        /* renamed from: a */
        private final String f1653a;

        /* renamed from: b */
        private final String f1654b;

        /* renamed from: c */
        private final String[] f1655c;

        /* renamed from: d */
        private final String f1656d;

        /* renamed from: e */
        private final String f1657e;

        /* renamed from: f */
        private final String[] f1658f;

        /* renamed from: g */
        private final String f1659g;

        /* renamed from: h */
        private final String f1660h;

        /* renamed from: i */
        private final String f1661i;

        /* renamed from: j */
        private final String f1662j;

        /* renamed from: k */
        private final String f1663k;

        /* renamed from: l */
        private final String f1664l;

        /* renamed from: m */
        private final String f1665m;

        /* renamed from: n */
        private final Uri f1666n;

        /* renamed from: o */
        private final int f1667o;

        /* renamed from: p */
        private final String f1668p;

        /* renamed from: q */
        private final int f1669q;

        /* renamed from: r */
        private final int f1670r;

        /* renamed from: s */
        private final int f1671s;

        /* renamed from: t */
        private final int[] f1672t;

        /* renamed from: u */
        private final String f1673u;

        /* renamed from: v */
        private final int f1674v;

        /* renamed from: w */
        private final String f1675w;

        /* renamed from: x */
        private final int f1676x;

        /* renamed from: y */
        private final String f1677y;

        /* renamed from: z */
        private final String f1678z;

        /* synthetic */ Notification(Bundle bundle, C1210a c1210a) {
            this(bundle);
        }

        /* renamed from: a */
        private Integer m1931a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.m2121w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return m1931a(this.f1675w);
        }

        public String getBody() {
            return this.f1656d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f1658f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f1657e;
        }

        public String getChannelId() {
            return this.f1665m;
        }

        public String getClickAction() {
            return this.f1663k;
        }

        public String getColor() {
            return this.f1662j;
        }

        public String getIcon() {
            return this.f1659g;
        }

        public Uri getImageUrl() {
            String str = this.f1668p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return m1931a(this.f1677y);
        }

        public String getIntentUri() {
            return this.f1664l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f1672t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f1666n;
        }

        public int getNotifyId() {
            return this.f1667o;
        }

        public String getSound() {
            return this.f1660h;
        }

        public String getTag() {
            return this.f1661i;
        }

        public String getTicker() {
            return this.f1678z;
        }

        public String getTitle() {
            return this.f1653a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f1655c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f1654b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.f1651A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return m1931a(this.f1652B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f1673u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f1673u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.m2121w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.m2121w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f1676x == 1;
        }

        public boolean isDefaultLight() {
            return this.f1669q == 1;
        }

        public boolean isDefaultSound() {
            return this.f1670r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f1671s == 1;
        }

        public boolean isLocalOnly() {
            return this.f1674v == 1;
        }

        private Notification(Bundle bundle) {
            this.f1653a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f1656d = bundle.getString("content");
            this.f1654b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f1657e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f1655c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f1658f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f1659g = bundle.getString(RemoteMessageConst.Notification.ICON);
            this.f1662j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f1660h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f1661i = bundle.getString("tag");
            this.f1665m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f1663k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f1664l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f1667o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f1666n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f1668p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f1669q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f1670r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f1671s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f1672t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f1673u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f1674v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f1675w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f1676x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f1677y = bundle.getString("priority", null);
            this.f1678z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.f1651A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.f1652B = bundle.getString("visibility", null);
        }
    }

    /* renamed from: com.huawei.hms.push.RemoteMessage$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class C1210a implements Parcelable.Creator<RemoteMessage> {
        C1210a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i) {
            return new RemoteMessage[i];
        }
    }

    public RemoteMessage(Bundle bundle) {
        this.f1647a = m1924a(bundle);
    }

    /* renamed from: a */
    private Bundle m1924a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject m1927b = m1927b(bundle);
        JSONObject m1926a = m1926a(m1927b);
        String string = JsonUtil.getString(m1926a, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(m1926a, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject m1930d = m1930d(m1926a);
        JSONObject m1928b = m1928b(m1930d);
        JSONObject m1929c = m1929c(m1930d);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && AbstractC1214d.m1941a(m1926a, m1930d, string)) {
            bundle2.putString("data", AbstractC1211a.m1934a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString(RemoteMessageConst.f1682TO);
        String string3 = bundle.getString(RemoteMessageConst.MSGTYPE);
        String string4 = JsonUtil.getString(m1926a, RemoteMessageConst.MSGID, null);
        bundle2.putString(RemoteMessageConst.f1682TO, string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString(RemoteMessageConst.MSGTYPE, string3);
        JsonUtil.transferJsonObjectToBundle(m1927b, bundle2, f1642f);
        bundle2.putBundle(RemoteMessageConst.NOTIFICATION, m1925a(m1927b, m1926a, m1930d, m1928b, m1929c));
        return bundle2;
    }

    /* renamed from: b */
    private static JSONObject m1927b(Bundle bundle) {
        try {
            return new JSONObject(AbstractC1211a.m1934a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.m2121w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* renamed from: c */
    private static JSONObject m1929c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    /* renamed from: d */
    private static JSONObject m1930d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f1647a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f1647a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m2121w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f1647a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f1647a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f1647a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m2121w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f1647a.getString(RemoteMessageConst.FROM);
    }

    public String getMessageId() {
        return this.f1647a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f1647a.getString(RemoteMessageConst.MSGTYPE);
    }

    public Notification getNotification() {
        Bundle bundle = this.f1647a.getBundle(RemoteMessageConst.NOTIFICATION);
        C1210a c1210a = null;
        if (this.f1648b == null && bundle != null) {
            this.f1648b = new Notification(bundle, c1210a);
        }
        if (this.f1648b == null) {
            this.f1648b = new Notification(new Bundle(), c1210a);
        }
        return this.f1648b;
    }

    public int getOriginalUrgency() {
        int i = this.f1647a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f1647a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f1647a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f1647a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.m2121w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f1647a.getString(RemoteMessageConst.f1682TO);
    }

    public String getToken() {
        return this.f1647a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f1647a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i = this.f1647a.getInt(RemoteMessageConst.URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1647a);
        parcel.writeSerializable(this.f1648b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f1647a = parcel.readBundle();
        this.f1648b = (Notification) parcel.readSerializable();
    }

    /* renamed from: b */
    private static JSONObject m1928b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    static {
        String[] strArr = new String[0];
        f1639c = strArr;
        int[] iArr = new int[0];
        f1640d = iArr;
        long[] jArr = new long[0];
        f1641e = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f1642f = hashMap;
        hashMap.put(RemoteMessageConst.FROM, "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f1643g = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f1644h = hashMap3;
        hashMap3.put(RemoteMessageConst.Notification.ICON, "");
        hashMap3.put(RemoteMessageConst.Notification.COLOR, "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f1645i = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f1646j = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new C1210a();
    }

    /* renamed from: a */
    private Bundle m1925a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f1643g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f1644h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f1645i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f1646j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    /* renamed from: a */
    private static JSONObject m1926a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
