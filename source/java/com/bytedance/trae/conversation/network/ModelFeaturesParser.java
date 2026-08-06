package com.bytedance.trae.conversation.network;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: ModelPricingPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "parse", "Lcom/bytedance/trae/conversation/network/ModelFeatures;", "rawFeatures", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelFeaturesParser {
    public static final ModelFeaturesParser INSTANCE = new ModelFeaturesParser();
    private static final Gson gson = new Gson();

    private ModelFeaturesParser() {
    }

    public final ModelFeatures parse(String rawFeatures) {
        Object obj;
        String str = rawFeatures;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            ModelFeaturesParser modelFeaturesParser = this;
            obj = Result.constructor-impl((ModelFeatures) gson.fromJson(rawFeatures, ModelFeatures.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (ModelFeatures) (Result.isFailure-impl(obj) ? null : obj);
    }
}
