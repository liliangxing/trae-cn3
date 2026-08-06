package com.bytedance.bdturing.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.common.utility.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u001a\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u001a\u0012\u0010\u0010\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0015\u001a\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017\u001a\u0010\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u001a\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u001a\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0015\u001a\u0006\u0010\u001f\u001a\u00020\u0004\u001a$\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u001a\"\u0010#\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e\u001a$\u0010#\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004¨\u0006$"}, d2 = {"appendUrlParams", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "url", "", "params", "Lorg/json/JSONObject;", "base64ToRgbBytes", "", "base64Str", "bitmapToBase64", MonitorConstant.BLANK_BITMAP, "Landroid/graphics/Bitmap;", "quality", "", "rgbBytes", "convertJson2Form", "dp2pix", "dpValue", "", "ctx", "Landroid/content/Context;", "findActivity", "Landroid/app/Activity;", "context", "getAvailableScreenSize", "Landroid/graphics/Point;", "activity", "getCurrentOrientation", "getDensity", "getManifestVersionCode", "getResolution", "appendFirstParam", Api.KEY_ENCRYPT_RESP_KEY, "value", "appendParams", "BdTuringSdk_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UtilsKt {
    public static final StringBuilder appendParams(StringBuilder sb, String str, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        return appendParams(sb, str, String.valueOf(i));
    }

    public static final StringBuilder appendParams(StringBuilder sb, String str, String str2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        if (str2 == null) {
            return sb;
        }
        try {
            sb.append("&").append(str).append("=").append(URLEncoder.encode(str2, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            LogUtil.printException(e);
        }
        return sb;
    }

    public static final StringBuilder appendFirstParam(StringBuilder sb, String str, String str2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        if (str2 == null) {
            return sb;
        }
        try {
            sb.append(str).append("=").append(URLEncoder.encode(str2, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            LogUtil.printException(e);
        }
        return sb;
    }

    public static final Activity findActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        do {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (!(contextWrapper instanceof Activity)) {
                context = contextWrapper.getBaseContext();
            } else {
                return (Activity) contextWrapper;
            }
        } while (context instanceof ContextWrapper);
        return null;
    }

    public static final StringBuilder appendUrlParams(String str, JSONObject jSONObject) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        StringBuilder sb = new StringBuilder(str);
        if (StringsKt.indexOf$default(str, '?', 0, false, 6, (Object) null) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                str2 = jSONObject.getString(next);
            } catch (Exception e) {
                e.printStackTrace();
                str2 = null;
            }
            arrayList.add(new Pair(next, str2));
        }
        sb.append(NetworkUtils.format(arrayList, UrlUtils.UTF_8));
        return sb;
    }

    public static final StringBuilder convertJson2Form(JSONObject jSONObject) {
        String str;
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                str = jSONObject.getString(next);
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            arrayList.add(new Pair(next, str));
        }
        sb.append(NetworkUtils.format(arrayList, UrlUtils.UTF_8));
        return sb;
    }

    public static final int getCurrentOrientation(Activity activity) {
        if (activity == null) {
            return 0;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        LogUtil.m162i("AbstractRequest", "rotation current " + rotation);
        if (rotation == 0) {
            return 2;
        }
        if (rotation != 1) {
            if (rotation == 2) {
                return 2;
            }
            if (rotation != 3) {
                return 0;
            }
        }
        return 1;
    }

    public static final String getResolution() {
        Resources resources;
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        DisplayMetrics displayMetrics = null;
        Context applicationContext = config != null ? config.getApplicationContext() : null;
        if (applicationContext != null && (resources = applicationContext.getResources()) != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        return new StringBuilder().append(displayMetrics != null ? displayMetrics.widthPixels : 0).append('*').append(displayMetrics != null ? displayMetrics.heightPixels : 0).toString();
    }

    public static final float getDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Method declaredMethod = DisplayMetrics.class.getDeclaredMethod("getDeviceDensity", new Class[0]);
            declaredMethod.setAccessible(true);
            if (declaredMethod.invoke(null, new Object[0]) != null) {
                return ((Integer) r0).intValue() / 160.0f;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            e.printStackTrace();
            return context.getApplicationContext().getResources().getDisplayMetrics().density;
        }
    }

    public static final int getManifestVersionCode(Context context) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static final String bitmapToBase64(Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, MonitorConstant.BLANK_BITMAP);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return Base64.encodeToString(byteArray, 2);
    }

    public static final String bitmapToBase64(byte[] bArr) {
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                return Base64.encodeToString(bArr, 2);
            }
        }
        return null;
    }

    public static final byte[] base64ToRgbBytes(String str) {
        Intrinsics.checkNotNullParameter(str, "base64Str");
        byte[] decode = Base64.decode(str, 2);
        Intrinsics.checkNotNullExpressionValue(decode, "bmpBytes");
        return decode;
    }

    public static final int dp2pix(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final Point getAvailableScreenSize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return new Point(rect.width(), rect.height());
    }
}
