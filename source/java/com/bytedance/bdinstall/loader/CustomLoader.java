package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.InstallOptions;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomLoader extends BaseLoader {
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomLoader(InstallOptions installOptions) {
        super(false, true);
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws SecurityException {
        Map<String, Object> commonHeader = this.mOptions.getCommonHeader();
        if (commonHeader == null) {
            return true;
        }
        try {
            if (commonHeader.isEmpty()) {
                return true;
            }
            for (Map.Entry<String, Object> entry : commonHeader.entrySet()) {
                if (entry != null) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
