package com.bytedance.sdk.account.induce;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class InduceResult implements Serializable {
    public JSONObject extraInfo;
    public String notShowLoginReason;
    public JSONObject sceneStrategy;
    public ArrayList<String> scenes;
    public boolean showLogin;
}
