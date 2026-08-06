package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PermissionBootRequestParam {
    private Activity curActivity;
    private JSONObject dialogFormData;
    private IPermissionBootDialog permissionBootDialogAbility;
    private String sceneCategory;
    private String scenes;

    public PermissionBootRequestParam(String str, String str2) {
        this.scenes = str;
        this.sceneCategory = str2;
    }

    public String getScenes() {
        return this.scenes;
    }

    public PermissionBootRequestParam setScenes(String str) {
        this.scenes = str;
        return this;
    }

    public String getSceneCategory() {
        return this.sceneCategory;
    }

    public PermissionBootRequestParam setSceneCategory(String str) {
        this.sceneCategory = str;
        return this;
    }

    public IPermissionBootDialog getPermissionBootDialogAbility() {
        return this.permissionBootDialogAbility;
    }

    public PermissionBootRequestParam setPermissionBootDialogAbility(IPermissionBootDialog iPermissionBootDialog) {
        this.permissionBootDialogAbility = iPermissionBootDialog;
        return this;
    }

    public Activity getCurActivity() {
        return this.curActivity;
    }

    public PermissionBootRequestParam setCurActivity(Activity activity) {
        this.curActivity = activity;
        return this;
    }

    public JSONObject getDialogFormData() {
        return this.dialogFormData;
    }

    public PermissionBootRequestParam setDialogFormData(JSONObject jSONObject) {
        this.dialogFormData = jSONObject;
        return this;
    }
}
