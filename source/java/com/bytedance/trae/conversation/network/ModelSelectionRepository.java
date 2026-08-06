package com.bytedance.trae.conversation.network;

import com.bytedance.trae.conversation.AccountSettingsKeva;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ModelSelectionRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;", "", "<init>", "()V", "TAG", "", "KEY_PREFIX_MODE", "KEY_PREFIX_SESSION", "MODE_CODE", "MODE_MTC", "gson", "Lcom/google/gson/Gson;", "environmentKey", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "modeKey", "mode", "Lcom/bytedance/trae/im/service/Mode;", "loadSelection", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "environment", "sessionId", "loadModeSelection", "loadSessionSelection", "saveModeSelection", "", "model", "saveSessionSelection", "resolveValidSelection", "selected", "models", "", "load", "key", "save", "sessionKey", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelSelectionRepository {
    private static final String KEY_PREFIX_MODE = "solo_model_selection_mode";
    private static final String KEY_PREFIX_SESSION = "solo_model_selection_session";
    public static final String MODE_CODE = "code";
    public static final String MODE_MTC = "mtc";
    private static final String TAG = "ModelSelectionRepository";
    public static final ModelSelectionRepository INSTANCE = new ModelSelectionRepository();
    private static final Gson gson = new Gson();

    private ModelSelectionRepository() {
    }

    public final String environmentKey(CliType cliType) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return cliType.getValue();
    }

    public final String modeKey(Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return mode == Mode.CODE ? "code" : MODE_MTC;
    }

    public final RemoteModelItem loadSelection(String environment, String mode, String sessionId) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(mode, "mode");
        RemoteModelItem loadSessionSelection = loadSessionSelection(environment, mode, sessionId);
        if (loadSessionSelection != null) {
            return loadSessionSelection;
        }
        RemoteModelItem loadModeSelection = loadModeSelection(environment, mode);
        return loadModeSelection == null ? RemoteModelItem.INSTANCE.auto() : loadModeSelection;
    }

    public final RemoteModelItem loadModeSelection(String environment, String mode) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return load(modeKey(environment, mode));
    }

    public final RemoteModelItem loadSessionSelection(String environment, String mode, String sessionId) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(mode, "mode");
        String str = sessionId;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return load(sessionKey(environment, mode, sessionId));
    }

    public final void saveModeSelection(String environment, String mode, RemoteModelItem model) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(model, "model");
        save(modeKey(environment, mode), model);
    }

    public final void saveSessionSelection(String environment, String mode, String sessionId, RemoteModelItem model) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(model, "model");
        String str = sessionId;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        save(sessionKey(environment, mode, sessionId), model);
    }

    public final RemoteModelItem resolveValidSelection(RemoteModelItem selected, List<RemoteModelItem> models) {
        Object obj;
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(models, "models");
        if (Intrinsics.areEqual(selected.getId(), RemoteModelItem.INSTANCE.auto().getId())) {
            return RemoteModelItem.INSTANCE.auto();
        }
        Iterator<T> it = models.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            RemoteModelItem remoteModelItem = (RemoteModelItem) obj;
            boolean z = true;
            if (!Intrinsics.areEqual(remoteModelItem.getId(), selected.getId()) && !Intrinsics.areEqual(remoteModelItem.getName(), selected.getName())) {
                String customModelId = selected.getCustomModelId();
                if ((customModelId == null || StringsKt.isBlank(customModelId)) || !Intrinsics.areEqual(remoteModelItem.getCustomModelId(), selected.getCustomModelId())) {
                    z = false;
                }
            }
            if (z) {
                break;
            }
        }
        RemoteModelItem remoteModelItem2 = (RemoteModelItem) obj;
        return remoteModelItem2 == null ? RemoteModelItem.INSTANCE.auto() : remoteModelItem2;
    }

    private final RemoteModelItem load(String key) {
        Object obj;
        String string = AccountSettingsKeva.INSTANCE.getKeva().getString(key, (String) null);
        if (string == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            ModelSelectionRepository modelSelectionRepository = this;
            obj = Result.constructor-impl((RemoteModelItem) gson.fromJson(string, RemoteModelItem.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "load failed, key=" + key, th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        RemoteModelItem remoteModelItem = (RemoteModelItem) obj;
        if (remoteModelItem == null || !(!StringsKt.isBlank(remoteModelItem.getName()))) {
            return null;
        }
        return remoteModelItem;
    }

    private final void save(String key, RemoteModelItem model) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ModelSelectionRepository modelSelectionRepository = this;
            AccountSettingsKeva.INSTANCE.getKeva().storeString(key, gson.toJson(model));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "save failed, key=" + key + ", model=" + model.getName(), th2);
        }
    }

    private final String modeKey(String environment, String mode) {
        return "solo_model_selection_mode_" + environment + '_' + mode;
    }

    private final String sessionKey(String environment, String mode, String sessionId) {
        return "solo_model_selection_session_" + environment + '_' + mode + '_' + sessionId;
    }
}
