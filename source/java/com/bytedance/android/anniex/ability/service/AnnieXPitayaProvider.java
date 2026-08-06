package com.bytedance.android.anniex.ability.service;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IAnnieXPitayaProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/AnnieXPitayaProvider;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "()V", "inference", "", "taskConfig", "Lcom/bytedance/android/anniex/ability/service/TaskConfig;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/anniex/ability/service/TaskResultCallback;", "data", "Lorg/json/JSONObject;", "isHostPitayaReady", "", "runPartialBlankDetect", "snapshot", "Landroid/graphics/Bitmap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class AnnieXPitayaProvider implements IAnnieXService {
    public void inference(TaskConfig taskConfig, TaskResultCallback callback, JSONObject data) {
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
    }

    public boolean isHostPitayaReady() {
        return false;
    }

    public void runPartialBlankDetect(Bitmap snapshot, TaskConfig taskConfig, JSONObject data, TaskResultCallback callback) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
