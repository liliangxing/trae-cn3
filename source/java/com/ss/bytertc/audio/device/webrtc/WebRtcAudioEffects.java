package com.ss.bytertc.audio.device.webrtc;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import com.bytedance.realx.base.RXLogging;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes7.dex */
public class WebRtcAudioEffects {
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffects";
    private static Map<String, List<String>> audioEffectBlackList = new HashMap();
    private static AudioEffect.Descriptor[] cachedEffects;
    private AcousticEchoCanceler aec;
    private NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public static boolean isAcousticEchoCancelerSupported() {
        return isAcousticEchoCancelerEffectAvailable();
    }

    public static boolean isNoiseSuppressorSupported() {
        return isNoiseSuppressorEffectAvailable();
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(Build.MODEL);
        if (contains) {
            RXLogging.w(TAG, Build.MODEL + " is blacklisted for HW AEC usage!");
        }
        return contains;
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(Build.MODEL);
        if (contains) {
            RXLogging.w(TAG, Build.MODEL + " is blacklisted for HW NS usage!");
        }
        return contains;
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID() {
        UUID uuid;
        try {
            uuid = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
        } catch (Exception e) {
            e.printStackTrace();
            uuid = null;
        }
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC) && uuid != null && descriptor.uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNoiseSuppressorExcludedByUUID() {
        UUID uuid;
        try {
            uuid = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
        } catch (Exception e) {
            e.printStackTrace();
            uuid = null;
        }
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_NS) && uuid != null && descriptor.uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAcousticEchoCancelerEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
    }

    private static boolean isNoiseSuppressorEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }

    public static boolean canUseAcousticEchoCanceler() {
        boolean z = (!isAcousticEchoCancelerSupported() || WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() || isAcousticEchoCancelerBlacklisted()) ? false : true;
        RXLogging.i(TAG, "canUseAcousticEchoCanceler: " + z);
        return z;
    }

    public static boolean canUseNoiseSuppressor() {
        boolean z = (!isNoiseSuppressorSupported() || WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() || isNoiseSuppressorBlacklisted()) ? false : true;
        RXLogging.i(TAG, "canUseNoiseSuppressor: " + z);
        return z;
    }

    public static WebRtcAudioEffects create() {
        return new WebRtcAudioEffects();
    }

    private WebRtcAudioEffects() {
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    public boolean setAEC(boolean enable) {
        RXLogging.i(TAG, "setAEC(" + enable + ")");
        if (!canUseAcousticEchoCanceler()) {
            RXLogging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        }
        if (this.aec != null && enable != this.shouldEnableAec) {
            RXLogging.e(TAG, "Platform AEC state can't be modified while recording");
            return false;
        }
        this.shouldEnableAec = enable;
        return true;
    }

    public boolean setNS(boolean enable) {
        RXLogging.i(TAG, "setNS(" + enable + ")");
        if (!canUseNoiseSuppressor()) {
            RXLogging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        }
        if (this.ns != null && enable != this.shouldEnableNs) {
            RXLogging.e(TAG, "Platform NS state can't be modified while recording");
            return false;
        }
        this.shouldEnableNs = enable;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e1, code lost:
    
        if (canUseNoiseSuppressor() != false) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005c A[Catch: Exception -> 0x0068, TryCatch #3 {Exception -> 0x0068, blocks: (B:64:0x0054, B:66:0x005c, B:67:0x0061), top: B:63:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enable(int audioSession) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        RXLogging.i(TAG, "enable(audioSession=" + audioSession + ")");
        boolean z8 = true;
        boolean z9 = false;
        if (isAcousticEchoCancelerSupported()) {
            try {
                if (this.aec != null) {
                    RXLogging.e(TAG, "Release previous aec instance");
                    this.aec.release();
                    this.aec = null;
                }
                AcousticEchoCanceler create = AcousticEchoCanceler.create(audioSession);
                this.aec = create;
                if (create != null) {
                    z3 = create.getEnabled();
                    try {
                    } catch (Exception e) {
                        z2 = false;
                        z = z3;
                        e = e;
                    }
                    try {
                        if (this.shouldEnableAec) {
                            if (canUseAcousticEchoCanceler()) {
                                z4 = true;
                                if (this.aec.setEnabled(z4) != 0) {
                                    RXLogging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                                }
                                z5 = this.aec.getEnabled();
                            }
                        }
                        if (this.aec.setEnabled(z4) != 0) {
                        }
                        z5 = this.aec.getEnabled();
                    } catch (Exception e2) {
                        boolean z10 = z4;
                        z = z3;
                        e = e2;
                        z2 = z10;
                        e.printStackTrace();
                        z3 = z;
                        z4 = z2;
                        z5 = false;
                        if (this.aec == null) {
                        }
                        if (isNoiseSuppressorSupported()) {
                        }
                    }
                    z4 = false;
                } else {
                    z3 = false;
                    z4 = false;
                    z5 = false;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                z2 = false;
            }
            if (this.aec == null) {
                RXLogging.i(TAG, "AcousticEchoCanceler: was " + (z3 ? "enabled" : "disabled") + ", enable: " + z4 + ", is now: " + (z5 ? "enabled" : "disabled"));
            } else {
                RXLogging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            return;
        }
        try {
            if (this.ns != null) {
                RXLogging.e(TAG, "Release previous ns instance");
                this.ns.release();
                this.ns = null;
            }
            NoiseSuppressor create2 = NoiseSuppressor.create(audioSession);
            this.ns = create2;
            if (create2 != null) {
                boolean enabled = create2.getEnabled();
                try {
                    if (this.shouldEnableNs) {
                    }
                    z8 = false;
                } catch (Exception e4) {
                    e = e4;
                    z8 = false;
                }
                try {
                    if (this.ns.setEnabled(z8) != 0) {
                        RXLogging.e(TAG, "Failed to set the NoiseSuppressor state");
                    }
                    z9 = enabled;
                    z7 = this.ns.getEnabled();
                } catch (Exception e5) {
                    e = e5;
                    Exception exc = e;
                    z6 = enabled;
                    e = exc;
                    e.printStackTrace();
                    z7 = false;
                    z9 = z6;
                    if (this.ns == null) {
                    }
                }
            } else {
                z7 = false;
                z8 = false;
            }
        } catch (Exception e6) {
            e = e6;
            z6 = false;
            z8 = false;
        }
        if (this.ns == null) {
            RXLogging.i(TAG, "NoiseSuppressor: was " + (z9 ? "enabled" : "disabled") + ", enable: " + z8 + ", is now: " + (z7 ? "enabled" : "disabled"));
        } else {
            RXLogging.e(TAG, "Failed to create the NoiseSuppressor instance");
        }
    }

    public void release() {
        RXLogging.i(TAG, "release");
        try {
            AcousticEchoCanceler acousticEchoCanceler = this.aec;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.release();
                this.aec = null;
            }
            NoiseSuppressor noiseSuppressor = this.ns;
            if (noiseSuppressor != null) {
                noiseSuppressor.release();
                this.ns = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aec = null;
            this.ns = null;
        }
    }

    private boolean effectTypeIsVoIP(UUID type) {
        return (AudioEffect.EFFECT_TYPE_AEC.equals(type) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(type) && isNoiseSuppressorSupported());
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        try {
            AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
            cachedEffects = queryEffects;
            return queryEffects;
        } catch (Exception e) {
            e.printStackTrace();
            return cachedEffects;
        }
    }

    private static boolean isEffectTypeAvailable(UUID effectType) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(effectType)) {
                return true;
            }
        }
        return false;
    }

    private static void initAudioEffectBlackList() {
        audioEffectBlackList.put("vivo", new ArrayList());
        audioEffectBlackList.get("vivo").add("Funtouch OS_3.1_PD1616_D_7.17.5");
    }

    public static boolean IsAudioEffectSupported() {
        if (audioEffectBlackList.isEmpty()) {
            initAudioEffectBlackList();
        }
        String productBrand = WebRtcAudioUtils.getProductBrand();
        if (productBrand.isEmpty() || !audioEffectBlackList.containsKey(productBrand)) {
            return true;
        }
        String romVersion = WebRtcAudioUtils.getRomVersion(productBrand);
        boolean contains = audioEffectBlackList.get(productBrand).contains(romVersion);
        RXLogging.w(TAG, "IsAudioEffectSupported, " + productBrand + ", " + romVersion + ", in black list = " + contains);
        return !contains;
    }
}
