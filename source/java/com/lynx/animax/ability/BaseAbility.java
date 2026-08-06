package com.lynx.animax.ability;

import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.base.IAnimaXCompositionReadyListener;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.listener.AnimaXFPSParam;
import com.lynx.animax.listener.AnimaXParam;
import com.lynx.animax.listener.AnimaXTapParam;
import com.lynx.animax.listener.IAnimationListener;
import com.lynx.animax.monitor.MonitorAbilityDelegate;
import com.lynx.animax.player.IVideoPlayer;
import com.lynx.animax.player.VideoPlayerConfig;
import com.lynx.animax.player.VideoPlayerFactory;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.service.ServiceRegistry;
import com.lynx.animax.service.ServiceScope;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BaseAbility {
    private WeakReference<IAnimaXCompositionReadyListener> mCompositionReadyListener;
    private final List<IAnimationListener> mListeners = new CopyOnWriteArrayList();
    private final MonitorAbilityDelegate mMonitorDelegate;
    private final ServiceRegistry mServiceRegistry;
    private final VideoPlayerConfig mVideoPlayerConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Action {
        void execute(IAnimationListener iAnimationListener);
    }

    public String redirectUrl(String str) {
        return str;
    }

    public BaseAbility() {
        ServiceRegistry serviceRegistry = new ServiceRegistry(getScope());
        this.mServiceRegistry = serviceRegistry;
        this.mVideoPlayerConfig = new VideoPlayerConfig(serviceRegistry);
        this.mMonitorDelegate = new MonitorAbilityDelegate(serviceRegistry);
    }

    public void initAnimaXPlayer(AnimaXPlayer animaXPlayer) {
        this.mMonitorDelegate.setAnimaXPlayer(animaXPlayer);
        addAnimationListener(this.mMonitorDelegate);
    }

    public void sendEvent(int i, ReadableMap readableMap) {
        sendEventOnUI(i, readableMap.asHashMap());
    }

    public IVideoPlayer createVideoPlayer(long j) {
        this.mVideoPlayerConfig.setSurfaceDestroyTimeout(DeviceUtil.getVideoSurfaceDestroyTimeout(this));
        return VideoPlayerFactory.create(j, this.mVideoPlayerConfig);
    }

    public void sendEventOnUI(final int i, final Map<String, Object> map) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseAbility.this.m2911lambda$sendEventOnUI$0$comlynxanimaxabilityBaseAbility(i, map);
            }
        });
    }

    public void addAnimationListener(IAnimationListener iAnimationListener) {
        this.mListeners.add(iAnimationListener);
    }

    public void removeAnimationListener(IAnimationListener iAnimationListener) {
        this.mListeners.remove(iAnimationListener);
    }

    public <T extends IAnimaXService> T getService(Class<T> cls) {
        return (T) this.mServiceRegistry.getService(cls);
    }

    public <T extends IAnimaXService> void registerService(Class<T> cls, T t) {
        this.mServiceRegistry.registerService(cls, t);
    }

    public <T extends IAnimaXService> void unregisterService(Class<T> cls) {
        this.mServiceRegistry.unregisterService(cls);
    }

    public void release() {
        this.mMonitorDelegate.onRelease();
        this.mServiceRegistry.release();
        this.mListeners.clear();
    }

    public void setCompositionReadyListener(IAnimaXCompositionReadyListener iAnimaXCompositionReadyListener) {
        this.mCompositionReadyListener = new WeakReference<>(iAnimaXCompositionReadyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onEvent, reason: merged with bridge method [inline-methods] */
    public void m2911lambda$sendEventOnUI$0$comlynxanimaxabilityBaseAbility(int i, Map<String, Object> map) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        switch (C13391.$SwitchMap$com$lynx$animax$ability$Event[Event.values()[i].ordinal()]) {
            case 1:
                final AnimaXParam animaXParam = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda4
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onComplete(AnimaXParam.this);
                    }
                });
                return;
            case 2:
                final AnimaXParam animaXParam2 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda7
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onStart(AnimaXParam.this);
                    }
                });
                return;
            case 3:
                final AnimaXParam animaXParam3 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda8
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onRepeat(AnimaXParam.this);
                    }
                });
                return;
            case 4:
                final AnimaXParam animaXParam4 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda9
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onCancel(AnimaXParam.this);
                    }
                });
                return;
            case 5:
                final AnimaXParam animaXParam5 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda10
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onReady(AnimaXParam.this);
                    }
                });
                return;
            case 6:
                final AnimaXErrorParam animaXErrorParam = new AnimaXErrorParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda11
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onError(AnimaXErrorParam.this);
                    }
                });
                return;
            case 7:
                final AnimaXParam animaXParam6 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda12
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onUpdate(AnimaXParam.this);
                    }
                });
                return;
            case 8:
                final AnimaXFPSParam animaXFPSParam = new AnimaXFPSParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda1
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onFPS(AnimaXFPSParam.this);
                    }
                });
                return;
            case 9:
                final AnimaXParam animaXParam7 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda2
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onCompositionReady(AnimaXParam.this);
                    }
                });
                WeakReference<IAnimaXCompositionReadyListener> weakReference = this.mCompositionReadyListener;
                IAnimaXCompositionReadyListener iAnimaXCompositionReadyListener = weakReference != null ? weakReference.get() : null;
                if (iAnimaXCompositionReadyListener != null) {
                    iAnimaXCompositionReadyListener.onCompositionReady();
                    return;
                }
                return;
            case 10:
                final AnimaXTapParam animaXTapParam = new AnimaXTapParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda3
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onTapLayers(AnimaXTapParam.this);
                    }
                });
                return;
            case 11:
                final AnimaXParam animaXParam8 = new AnimaXParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda5
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onFirstFrame(AnimaXParam.this);
                    }
                });
                return;
            case 12:
                final AnimaXErrorParam animaXErrorParam2 = new AnimaXErrorParam(map);
                notifyListeners(new Action() { // from class: com.lynx.animax.ability.BaseAbility$$ExternalSyntheticLambda6
                    @Override // com.lynx.animax.ability.BaseAbility.Action
                    public final void execute(IAnimationListener iAnimationListener) {
                        iAnimationListener.onWarning(AnimaXErrorParam.this);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.animax.ability.BaseAbility$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C13391 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$animax$ability$Event;

        static {
            int[] iArr = new int[Event.values().length];
            $SwitchMap$com$lynx$animax$ability$Event = iArr;
            try {
                iArr[Event.COMPLETION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.READY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.UPDATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.FPS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.COMPOSITION_READY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.TAP_LAYERS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.FIRST_FRAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$lynx$animax$ability$Event[Event.WARNING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private void notifyListeners(Action action) {
        Iterator<IAnimationListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            action.execute(it.next());
        }
    }

    protected ServiceScope getScope() {
        return ServiceScope.DEFAULT;
    }

    public VideoPlayerConfig getVideoPlayerConfig() {
        return this.mVideoPlayerConfig;
    }

    public MonitorAbilityDelegate getMonitorDelegate() {
        return this.mMonitorDelegate;
    }
}
