package com.bytedance.tobshadow.bdtracker;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.im.model.ParsedChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.e4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0416e4 {

    /* renamed from: a */
    public static final String[] f557a = {Constant.KEY_AID, "region", "os", "package", Constant.KEY_APP_VERSION, BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, Constant.KEY_OS_VERSION, Constant.KEY_DEVICE_MODEL, "resolution", SettingsTracker.TYPE_LANGUAGE, "timezone", "access", IGoogleService.ResponseKey.DISPLAY_NAME, Constant.KEY_CHANNEL, "carrier", "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "rom", "manifest_version_code", Constant.KEY_DEVICE_MANUFACTURER, "clientudid", "sig_hash", "display_density", Constant.KEY_OS_API, Constant.KEY_UPDATE_VERSION_CODE, "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid"};

    /* renamed from: b */
    public static final String[] f558b = {"setOnce", "synchronize"};

    /* renamed from: c */
    public static final int[] f559c = {-1, -1};

    /* renamed from: d */
    public static final long[] f560d = {-1, -1};

    /* renamed from: com.bytedance.tobshadow.bdtracker.e4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements UserProfileCallback {

        /* renamed from: a */
        public final /* synthetic */ int f561a;

        /* renamed from: b */
        public final /* synthetic */ JSONObject f562b;

        /* renamed from: c */
        public final /* synthetic */ UserProfileCallback f563c;

        public a(int i, JSONObject jSONObject, UserProfileCallback userProfileCallback) {
            this.f561a = i;
            this.f562b = jSONObject;
            this.f563c = userProfileCallback;
        }

        @Override // com.bytedance.tobshadow.applog.profile.UserProfileCallback
        public void onFail(int i) {
            this.f563c.onFail(i);
        }

        @Override // com.bytedance.tobshadow.applog.profile.UserProfileCallback
        public void onSuccess() {
            C0416e4.f559c[this.f561a] = this.f562b.toString().hashCode();
            C0416e4.f560d[this.f561a] = System.currentTimeMillis();
            this.f563c.onSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0118 A[Catch: JSONException -> 0x0131, TryCatch #0 {JSONException -> 0x0131, blocks: (B:32:0x0105, B:34:0x0111, B:36:0x0118, B:37:0x012d, B:53:0x00f1, B:54:0x0100), top: B:52:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m388a(C0475n0 c0475n0, int i, JSONObject jSONObject, UserProfileCallback userProfileCallback, Handler handler, boolean z) {
        boolean z2;
        Application application;
        String str;
        JSONObject jSONObject2;
        if (z) {
            z2 = true;
        } else {
            boolean z3 = System.currentTimeMillis() - f560d[i] > 60000;
            z2 = (jSONObject == null || f559c[i] == jSONObject.toString().hashCode()) ? false : true;
            c0475n0.f834d.f764D.error(9, "exec " + i + ", " + z3 + ", " + z2, new Object[0]);
            if (!z3) {
                if (userProfileCallback != null) {
                    userProfileCallback.onFail(4);
                    return;
                }
                return;
            }
        }
        if (!z2) {
            if (userProfileCallback != null) {
                userProfileCallback.onSuccess();
                return;
            }
            return;
        }
        Application application2 = c0475n0.f834d.f785n;
        String did = c0475n0.f834d.getDid();
        String str2 = c0475n0.f834d.f784m;
        String profileUri = c0475n0.m554e().getProfileUri();
        if (TextUtils.isEmpty(did) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(profileUri)) {
            if (userProfileCallback != null) {
                userProfileCallback.onFail(3);
                return;
            }
            return;
        }
        String m251a = C0380a.m251a(profileUri, String.format("/service/api/v3/userprofile/%s/%s", str2, f558b[i]));
        C0467m c0467m = c0475n0.f834d;
        JSONObject header = c0467m.getHeader();
        JSONObject jSONObject3 = new JSONObject();
        if (header != null) {
            application = application2;
            try {
                str = str2;
                try {
                    jSONObject2 = new JSONObject(header, f557a);
                    jSONObject2.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, C0411e.m347a((Object) header.optString(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION)));
                    jSONObject2.put("tz_offset", C0411e.m347a(header.opt("tz_offset")));
                } catch (JSONException e) {
                    e = e;
                    try {
                        c0467m.f764D.error(9, "JSON handle failed", e, new Object[0]);
                        jSONObject2 = new JSONObject();
                        jSONObject3.put("header", jSONObject2);
                        jSONObject3.put(IAppAuthService.Scope.PROFILE, jSONObject);
                        JSONObject jSONObject4 = new JSONObject();
                        if (header != null) {
                        }
                        jSONObject3.put(ParsedChatMessage.ROLE_USER, jSONObject4);
                    } catch (JSONException e2) {
                        c0467m.f764D.error(9, "JSON handle failed", e2, new Object[0]);
                    }
                    RunnableC0437h4 runnableC0437h4 = new RunnableC0437h4(c0475n0.f834d, m251a, str, jSONObject3, new a(i, jSONObject, userProfileCallback), application);
                    if (handler != null) {
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                str = str2;
            }
            jSONObject3.put("header", jSONObject2);
            jSONObject3.put(IAppAuthService.Scope.PROFILE, jSONObject);
            JSONObject jSONObject42 = new JSONObject();
            if (header != null) {
                jSONObject42.put("device_id", header.opt("device_id"));
                jSONObject42.put("user_id", header.opt("user_id"));
                jSONObject42.put("ssid", header.opt("ssid"));
            }
            jSONObject3.put(ParsedChatMessage.ROLE_USER, jSONObject42);
            RunnableC0437h4 runnableC0437h42 = new RunnableC0437h4(c0475n0.f834d, m251a, str, jSONObject3, new a(i, jSONObject, userProfileCallback), application);
            if (handler != null) {
                handler.post(runnableC0437h42);
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c0475n0.f834d.f764D.error(9, "Not allowed on main looper", new Object[0]);
            }
            runnableC0437h42.run();
            return;
        }
        application = application2;
        str = str2;
        jSONObject2 = new JSONObject();
        jSONObject3.put("header", jSONObject2);
        jSONObject3.put(IAppAuthService.Scope.PROFILE, jSONObject);
        JSONObject jSONObject422 = new JSONObject();
        if (header != null) {
        }
        jSONObject3.put(ParsedChatMessage.ROLE_USER, jSONObject422);
        RunnableC0437h4 runnableC0437h422 = new RunnableC0437h4(c0475n0.f834d, m251a, str, jSONObject3, new a(i, jSONObject, userProfileCallback), application);
        if (handler != null) {
        }
    }
}
