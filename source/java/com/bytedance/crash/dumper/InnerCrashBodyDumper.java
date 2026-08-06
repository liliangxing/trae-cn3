package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InnerCrashBodyDumper implements ICrashBodyExtensionDumper {
    public static final String BYTEST_FILE = "bytest.json";
    public static final String PATCH_INFO = "patch_info";
    private final String PATCH_FILE_NAME = "patch_info.json";
    private ICommonParams params;

    public InnerCrashBodyDumper(ICommonParams iCommonParams) {
        this.params = iCommonParams;
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void dump(File file) {
        try {
            dumpPatchInfo(file);
            BytestConfig.dump(new File(file, BYTEST_FILE));
        } catch (Exception unused) {
        }
    }

    private void dumpPatchInfo(File file) {
        try {
            List<String> patchInfo = this.params.getPatchInfo();
            if (patchInfo == null) {
                return;
            }
            JsonDumper jsonDumper = new JsonDumper(new File(file, "patch_info.json").getAbsolutePath());
            jsonDumper.arrayBegin();
            boolean z = false;
            for (String str : patchInfo) {
                if (z) {
                    jsonDumper.next();
                }
                jsonDumper.append(str);
                z = true;
            }
            jsonDumper.arrayEnd();
            jsonDumper.release();
        } catch (Throwable unused) {
        }
    }

    private void loadPatchInfo(JSONObject jSONObject, File file) {
        try {
            String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "patch_info.json"));
            if (readUtf8File != null) {
                JSONUtils.put(jSONObject, PATCH_INFO, new JSONArray(readUtf8File));
            }
        } catch (Exception e) {
            NpthLog.m233i(e);
        }
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void load(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        loadPatchInfo(jSONObject, file);
        JSONObject expandFilters = BytestConfig.expandFilters(new File(file, BYTEST_FILE), jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject == null) {
            BytestConfig.load(expandFilters, jSONObject2);
        } else {
            BytestConfig.load(expandFilters, optJSONObject);
        }
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public JSONObject load(CrashType crashType) {
        if (crashType != CrashType.ENSURE) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        loadPatchInfo(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        BytestConfig.expandFilters(jSONObject2);
        JSONUtils.put(jSONObject, "filters", jSONObject2);
        return jSONObject;
    }

    private void loadPatchInfo(JSONObject jSONObject) {
        List<String> patchInfo;
        try {
            ICommonParams iCommonParams = this.params;
            if (iCommonParams != null && (patchInfo = iCommonParams.getPatchInfo()) != null && !patchInfo.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = patchInfo.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put(PATCH_INFO, jSONArray);
            }
        } catch (Throwable unused) {
        }
    }
}
