package com.lynx.animax.ability;

import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.listener.AnimaXFPSParam;
import com.lynx.animax.listener.AnimaXParam;
import com.lynx.animax.listener.AnimaXTapParam;
import com.lynx.animax.listener.IAnimationListener;
import com.lynx.animax.service.ServiceScope;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.event.LynxCustomEvent;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxAbility extends BaseAbility implements IAnimationListener {
    private static final String EVENT_CANCEL = "cancel";
    private static final String EVENT_COMPLETION = "completion";
    private static final String EVENT_COMPOSITION_READY = "compositionready";
    private static final String EVENT_ERROR = "error";
    private static final String EVENT_FIRST_FRAME = "firstframe";
    private static final String EVENT_FPS = "fps";
    private static final String EVENT_READY = "ready";
    private static final String EVENT_REPEAT = "repeat";
    private static final String EVENT_START = "start";
    private static final String EVENT_TAP_LAYERS = "taplayers";
    private static final String EVENT_UPDATE = "update";
    private static final String EVENT_WARNING = "warning";
    private static final String TAG = "LynxAbility";
    private boolean disableShowEventLogbox;
    private final WeakReference<LynxContext> mContext;
    private boolean mListenUpdate = true;
    private final WeakReference<LynxBaseUI> mUI;

    public LynxAbility(LynxBaseUI lynxBaseUI, LynxContext lynxContext) {
        this.disableShowEventLogbox = false;
        this.mUI = new WeakReference<>(lynxBaseUI);
        this.mContext = new WeakReference<>(lynxContext);
        addAnimationListener(this);
        this.disableShowEventLogbox = DeviceUtil.disableShowEventLogbox(this);
    }

    public void setListenUpdate(boolean z) {
        this.mListenUpdate = z;
    }

    public boolean getListenUpdate() {
        return this.mListenUpdate;
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onStart(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_START, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onReady(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_READY, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onComplete(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_COMPLETION, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onRepeat(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_REPEAT, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onCancel(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_CANCEL, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onWarning(AnimaXErrorParam animaXErrorParam) {
        sendEventToJs(EVENT_WARNING, animaXErrorParam);
        showLynxLogBox(animaXErrorParam, LynxError.LEVEL_WARN);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onError(AnimaXErrorParam animaXErrorParam) {
        int errorCode = animaXErrorParam.getErrorCode();
        if (errorCode == AnimaXError.VIDEO_PLAYER_ERROR.getErrorCode() || errorCode == AnimaXError.VIDEO_PLAYER_ERROR_HAS_OCCURRED.getErrorCode()) {
            return;
        }
        sendEventToJs("error", animaXErrorParam);
        showLynxLogBox(animaXErrorParam, "error");
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onUpdate(AnimaXParam animaXParam) {
        if (this.mListenUpdate) {
            sendEventToJs("update", animaXParam);
        }
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onFPS(AnimaXFPSParam animaXFPSParam) {
        sendEventToJs(EVENT_FPS, animaXFPSParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onTapLayers(AnimaXTapParam animaXTapParam) {
        sendEventToJs(EVENT_TAP_LAYERS, animaXTapParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onFirstFrame(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_FIRST_FRAME, animaXParam);
    }

    @Override // com.lynx.animax.listener.IAnimationListener
    public void onCompositionReady(AnimaXParam animaXParam) {
        sendEventToJs(EVENT_COMPOSITION_READY, animaXParam);
    }

    private void sendEventToJs(String str, AnimaXParam animaXParam) {
        LynxBaseUI lynxBaseUI = this.mUI.get();
        LynxContext lynxContext = this.mContext.get();
        if (lynxBaseUI == null || lynxContext == null) {
            return;
        }
        lynxContext.getEventEmitter().sendCustomEvent(new LynxCustomEvent(lynxBaseUI.getSign(), str, animaXParam.getOriginParams()) { // from class: com.lynx.animax.ability.LynxAbility.1
            public String paramsName() {
                return "detail";
            }
        });
    }

    private void showLynxLogBox(AnimaXErrorParam animaXErrorParam, String str) {
        LynxContext lynxContext;
        if (this.disableShowEventLogbox || (lynxContext = this.mContext.get()) == null) {
            return;
        }
        LynxError lynxError = new LynxError(animaXErrorParam.getErrorCode(), animaXErrorParam.getErrorMessage(), "", str, -2);
        lynxError.setLogBoxOnly(true);
        lynxContext.handleLynxError(lynxError);
    }

    @Override // com.lynx.animax.ability.BaseAbility
    public String redirectUrl(String str) {
        LynxContext lynxContext = this.mContext.get();
        return lynxContext == null ? str : ImageUrlRedirectUtils.redirectUrl(lynxContext, str);
    }

    @Override // com.lynx.animax.ability.BaseAbility
    protected ServiceScope getScope() {
        return LynxAnimaX.inst().getScope();
    }
}
