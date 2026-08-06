package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.client.Header;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BoeUtils {
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static volatile String mBoeHttpsSuffix;
    private static volatile String mBoeSuffix;
    private static volatile boolean mDowngradeToHttp;
    private static volatile boolean mEnableOkhttpBoeProxy;
    private static volatile List<String> mOkhttpBypassBoeHostList = new ArrayList();
    private static volatile List<String> mOkhttpBypassBoePathList = new ArrayList();
    private static volatile boolean mHasReadBoeConfigFile = false;
    private static volatile List<Pattern> mOkhttpBypassBoeRegexList = new ArrayList();
    private static volatile List<String> mOkhttpBypassBoeHostWithTNC = new CopyOnWriteArrayList();

    public static boolean isBoeProxyEnabledByTTNetConfig(Context context) {
        String configFromAssets = getConfigFromAssets(context, TTNET_CONFIG_FILE);
        if (!TextUtils.isEmpty(configFromAssets)) {
            try {
                if (new JSONObject(configFromAssets).optBoolean("boe_proxy_enabled", false)) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (!mEnableOkhttpBoeProxy || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("boe_bypass_host_list")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!StringUtils.isEmpty(optString)) {
                mOkhttpBypassBoeHostWithTNC.add(optString);
            }
        }
    }

    public static boolean isBoeProxyEnabledByBoeFlag(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return false;
        }
        try {
            return new File(new StringBuilder().append(absolutePath).append("/ttnet_boe.flag").toString()).exists();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String getConfigFromAssets(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            String str2 = new String(bArr, "UTF-8");
            if (inputStream == null) {
                return str2;
            }
            try {
                inputStream.close();
                return str2;
            } catch (IOException e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
    }

    public static String tryAddOkhttpBoeSuffix(Context context, String str, List<Header> list) {
        if (!mHasReadBoeConfigFile && !mEnableOkhttpBoeProxy) {
            mEnableOkhttpBoeProxy = isBoeProxyEnabledByTTNetConfig(context) || isBoeProxyEnabledByBoeFlag(context);
            mHasReadBoeConfigFile = true;
        }
        if (mEnableOkhttpBoeProxy && (!TextUtils.isEmpty(mBoeSuffix) || !TextUtils.isEmpty(mBoeHttpsSuffix))) {
            Uri parse = Uri.parse(str);
            if (StringUtils.isEmpty(parse.getScheme()) || StringUtils.isEmpty(parse.getHost()) || StringUtils.isEmpty(parse.getPath()) || inBypassBoeList(parse.getHost(), parse.getPath())) {
                return str;
            }
            for (Header header : list) {
                if (!StringUtils.isEmpty(header.getName()) && !StringUtils.isEmpty(header.getValue()) && header.getName().equals("bypass-boe") && header.getValue().equals("1")) {
                    return str;
                }
            }
            String downgradeToHttpScheme = downgradeToHttpScheme(str, parse.getScheme());
            if (InetAddressUtils.isIPv4Address(parse.getHost()) || InetAddressUtils.isIPv6StdAddress(parse.getHost()) || InetAddressUtils.isIPv6HexCompressedAddress(parse.getHost())) {
                return downgradeToHttpScheme;
            }
            if (mDowngradeToHttp) {
                String host = parse.getHost();
                return !host.contains(mBoeSuffix) ? downgradeToHttpScheme.replaceFirst(host, host + mBoeSuffix) : downgradeToHttpScheme;
            }
            return replaceBoeHttpsSuffix(downgradeToHttpScheme, parse.getHost());
        }
        return str;
    }

    public static String replaceUrlWithoutBoeHttpSuffix(String str) {
        if (!mEnableOkhttpBoeProxy || !mDowngradeToHttp || str == null || !str.contains(mBoeSuffix)) {
            return null;
        }
        String scheme = Uri.parse(str).getScheme();
        if ("http".equals(scheme)) {
            str = str.replaceFirst("http", "https");
        } else if ("ws".equals(scheme)) {
            str = str.replaceFirst("ws", "wss");
        }
        return str.replaceFirst(mBoeSuffix, "");
    }

    private static String replaceBoeHttpsSuffix(String str, String str2) {
        String[] split;
        int length;
        if (TextUtils.isEmpty(mBoeHttpsSuffix) || (length = (split = str2.split("\\.")).length) < 2) {
            return str;
        }
        int i = length - 2;
        String str3 = split[i];
        return str3.contains(mBoeHttpsSuffix) ? str : replaceFirstSubstringAfterOffset(str, findCharOffsetByNumbersInOrder(str, LibrarianImpl.Constants.DOT, i), str3, str3 + mBoeHttpsSuffix);
    }

    private static String replaceFirstSubstringAfterOffset(String str, int i, String str2, String str3) {
        return str.substring(0, i) + str.substring(i).replaceFirst(str2, str3);
    }

    private static int findCharOffsetByNumbersInOrder(String str, String str2, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i3 = str.indexOf(str2, i2 == 0 ? 0 : i3 + 1);
            if (i3 == -1) {
                return 0;
            }
            i2++;
        }
        return i3;
    }

    private static String downgradeToHttpScheme(String str, String str2) {
        String str3;
        if (!mDowngradeToHttp) {
            return str;
        }
        if (str2.equals("https")) {
            str3 = "http";
        } else {
            str3 = str2.equals("wss") ? "ws" : null;
        }
        return !StringUtils.isEmpty(str3) ? str.replaceFirst(str2, str3) : str;
    }

    public static void setBoeSuffix(String str) {
        mBoeSuffix = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mDowngradeToHttp = true;
    }

    public static void setBoeHttpsSuffix(String str) {
        mBoeHttpsSuffix = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mDowngradeToHttp = false;
    }

    public static void enableOkhttpBoeProxy(boolean z) {
        mEnableOkhttpBoeProxy = z;
    }

    public static void setOkhttpBypassBoeJson(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("bypass_boe_host_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!StringUtils.isEmpty(optString)) {
                        mOkhttpBypassBoeHostList.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("bypass_boe_path_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (!StringUtils.isEmpty(optString2)) {
                        mOkhttpBypassBoePathList.add(optString2);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("bypass_boe_url_list");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    String optString3 = optJSONArray3.optString(i3);
                    if (!StringUtils.isEmpty(optString3)) {
                        mOkhttpBypassBoeRegexList.add(Pattern.compile(optString3, 2));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean inBypassBoeList(String str, String str2) {
        if (mOkhttpBypassBoeHostList.isEmpty() && mOkhttpBypassBoePathList.isEmpty() && mOkhttpBypassBoeRegexList.isEmpty() && mOkhttpBypassBoeHostWithTNC.isEmpty()) {
            return false;
        }
        Iterator<String> it = mOkhttpBypassBoeHostList.iterator();
        while (it.hasNext()) {
            if (UrlUtils.matchPattern(str, it.next())) {
                return true;
            }
        }
        Iterator<String> it2 = mOkhttpBypassBoeHostWithTNC.iterator();
        while (it2.hasNext()) {
            if (UrlUtils.matchPattern(str, it2.next())) {
                return true;
            }
        }
        Iterator<String> it3 = mOkhttpBypassBoePathList.iterator();
        while (it3.hasNext()) {
            if (UrlUtils.matchPattern(str2, it3.next())) {
                return true;
            }
        }
        String str3 = str + str2;
        Iterator<Pattern> it4 = mOkhttpBypassBoeRegexList.iterator();
        while (it4.hasNext()) {
            if (it4.next().matcher(str3).matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOkhttpBoeProxyEnabled() {
        return mEnableOkhttpBoeProxy;
    }
}
