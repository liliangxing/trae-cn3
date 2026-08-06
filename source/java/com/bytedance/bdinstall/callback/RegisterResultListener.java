package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;
import org.json.JSONException;

/* loaded from: classes3.dex */
public interface RegisterResultListener {
    boolean onRegisterResult(TTResponse tTResponse, Env env, IInstallParameters iInstallParameters) throws JSONException;
}
