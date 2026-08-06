package com.bytedance.helios.statichook.config;

import com.bytedance.helios.statichook.api.ActionInvoker;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ApiHookDef {
    private static final ActionInvoker[] EMPTY_INVOKERS = new ActionInvoker[0];
    private final String abstractOfApi;
    private String[] actionInvokerNames;
    private ActionInvoker[] actionInvokers = EMPTY_INVOKERS;
    private String[] dataTypes;
    private int id;
    private final String invokeType;
    private int permissionMode;
    private String[] permissions;
    private final String resourceId;
    private final String resourceName;

    public ApiHookDef(int i, String str, String str2, String str3, String[] strArr, int i2, String[] strArr2, String[] strArr3, String str4) {
        this.id = i;
        this.abstractOfApi = str;
        this.resourceId = str2;
        this.resourceName = str3;
        this.permissions = strArr;
        this.permissionMode = i2;
        this.dataTypes = strArr2;
        this.actionInvokerNames = strArr3;
        this.invokeType = str4;
    }

    public int getId() {
        return this.id;
    }

    public String getAbstractOfApi() {
        return this.abstractOfApi;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public String[] getPermissions() {
        return this.permissions;
    }

    public int getPermissionMode() {
        return this.permissionMode;
    }

    public String[] getDataTypes() {
        return this.dataTypes;
    }

    public String[] getActionInvokerNames() {
        return this.actionInvokerNames;
    }

    public void setActionInvokerNames(String[] strArr) {
        this.actionInvokerNames = strArr;
    }

    public ActionInvoker[] getActionInvokers() {
        return this.actionInvokers;
    }

    public void setActionInvokers(ActionInvoker[] actionInvokerArr) {
        this.actionInvokers = actionInvokerArr;
    }

    public String getInvokeType() {
        return this.invokeType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApiHookDef apiHookDef = (ApiHookDef) obj;
        return this.id == apiHookDef.id && Objects.equals(this.abstractOfApi, apiHookDef.abstractOfApi);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), this.abstractOfApi);
    }
}
