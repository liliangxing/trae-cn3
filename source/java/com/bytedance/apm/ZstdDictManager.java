package com.bytedance.apm;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.forest.model.URIQueryParamKeys;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IZstdDict;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ZstdDictManager implements IZstdDict {
    public static final String DICT_INTERVAL = "dict_interval";
    private static final String DICT_VERSION = "dict_version";
    public static final String DICT_VERSION_HEADER_KEY = "slardar-zstd-version";
    private byte[] mDict;
    private String mDictVersion;
    private long mInterval;
    private volatile boolean mIsInit;
    private String url;

    public Pair<byte[], String> getDictAndDictVersion() {
        ensureInit();
        byte[] bArr = this.mDict;
        if (bArr == null || System.currentTimeMillis() - this.mInterval > 604800000) {
            downloadDict();
            bArr = this.mDict;
        }
        return new Pair<>(bArr, this.mDictVersion);
    }

    private void ensureInit() {
        if (this.mIsInit) {
            return;
        }
        this.mDict = FileUtils.readFileToByteArray(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"));
        SharedPreferences sharedPreferences = com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0);
        this.mInterval = sharedPreferences.getLong(DICT_INTERVAL, 0L);
        this.mDictVersion = sharedPreferences.getString(DICT_VERSION, null);
        this.mIsInit = true;
    }

    private void downloadDict() {
        HashMap hashMap = new HashMap(com.bytedance.apm6.foundation.context.ApmContext.getUrlParams());
        hashMap.put("slardar_zstd_dict_type", "monitor");
        hashMap.put("zstd_client_code_version", URIQueryParamKeys.DYNAMIC);
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        try {
            HttpResponse doPost = com.bytedance.apm6.foundation.context.ApmContext.doPost(UrlUtils.addParamsToURL(this.url, hashMap), hashMap, new JSONObject(hashMap).toString().getBytes());
            if (doPost == null || doPost.getResponseBytes() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(new String(doPost.getResponseBytes()));
            String string = jSONObject.getString(DICT_VERSION);
            String string2 = jSONObject.getString("dict");
            if (jSONObject.getInt(AlogMonitor.ALOG_RESULT_CODE) != 200) {
                return;
            }
            byte[] decode = Base64.decode(string2, 0);
            writeFile(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"), decode);
            this.mDictVersion = string;
            this.mDict = decode;
            this.mInterval = System.currentTimeMillis();
            com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0).edit().putLong(DICT_INTERVAL, this.mInterval).putString(DICT_VERSION, string).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDomain(String str) {
        this.url = "https://" + str + ReportConsts.ZSTD_DICT_PATH;
    }

    private static void writeFile(File file, byte[] bArr) throws IOException {
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            file.exists();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                IOUtils.safeClose(fileOutputStream2);
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                IOUtils.safeClose(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IOUtils.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
