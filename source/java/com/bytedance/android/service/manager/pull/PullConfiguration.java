package com.bytedance.android.service.manager.pull;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PullConfiguration {
    public static final String PROCESS_NAME_MAIN = "main";
    public static final String PROCESS_NAME_PUSH = "push";
    public static final String PROCESS_NAME_SMP = "smp";
    public static final int SCENE_ALLIANCE = 2;
    public static final int SCENE_ONLINE = 1;
    private String did;
    private String fromAid = "";
    private String fromDid = "";
    private boolean isActive;
    private JSONObject mSettingsFromCompose;
    private String processName;
    private int sceneId;

    public PullConfiguration(String str, int i, String str2) {
        this.processName = str;
        this.sceneId = i;
        this.did = str2;
    }

    public String getFromAid() {
        return this.fromAid;
    }

    public String getPullAidAndDids() {
        if (!TextUtils.isEmpty(this.fromAid) && !TextUtils.isEmpty(this.fromDid)) {
            return this.fromAid + Constants.COLON_SEPARATOR + this.fromDid;
        }
        if (TextUtils.isEmpty(this.fromAid) && TextUtils.isEmpty(this.fromDid)) {
            return "";
        }
        if (TextUtils.isEmpty(this.fromAid)) {
            return Constants.COLON_SEPARATOR + this.fromDid;
        }
        return this.fromAid + Constants.COLON_SEPARATOR;
    }

    public PullConfiguration setFromAid(String str) {
        this.fromAid = str;
        return this;
    }

    public String getFromDid() {
        return this.fromDid;
    }

    public PullConfiguration setFromDid(String str) {
        this.fromDid = str;
        return this;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public PullConfiguration setIsActive(boolean z) {
        this.isActive = z;
        return this;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public PullConfiguration setDid(String str) {
        this.did = str;
        return this;
    }

    public String getDid() {
        return this.did;
    }

    public String getProcessName() {
        return this.processName;
    }

    public JSONObject getSettingsFromCompose() {
        return this.mSettingsFromCompose;
    }

    public PullConfiguration setSettingsFromCompose(JSONObject jSONObject) {
        this.mSettingsFromCompose = jSONObject;
        return this;
    }
}
