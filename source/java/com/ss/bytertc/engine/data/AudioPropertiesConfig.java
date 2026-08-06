package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioPropertiesConfig {
    public AudioPropertiesMode audioReportMode;
    public boolean enableSpectrum;
    public boolean enableVad;
    public boolean enableVoicePitch;
    public int interval;
    public AudioReportMode localMainReportMode;
    public float smooth;

    public AudioPropertiesConfig(int interval) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = interval;
    }

    public AudioPropertiesConfig(int interval, boolean enableSpectrum, boolean enableVad) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = interval;
        this.enableSpectrum = enableSpectrum;
        this.enableVad = enableVad;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
    }

    public AudioPropertiesConfig(int interval, boolean enableSpectrum, boolean enableVad, AudioReportMode localMainReportMode, float smooth, AudioPropertiesMode audioReportMode) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        AudioPropertiesMode audioPropertiesMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.enableVoicePitch = false;
        this.interval = interval;
        this.enableSpectrum = enableSpectrum;
        this.enableVad = enableVad;
        this.localMainReportMode = localMainReportMode;
        this.smooth = smooth;
        this.audioReportMode = audioReportMode;
    }

    public AudioPropertiesConfig(int interval, boolean enableSpectrum, boolean enableVad, AudioReportMode localMainReportMode) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = interval;
        this.enableSpectrum = enableSpectrum;
        this.enableVad = enableVad;
        this.localMainReportMode = localMainReportMode;
    }

    public AudioPropertiesConfig(int interval, boolean enableSpectrum, boolean enableVad, AudioReportMode localMainReportMode, float smooth) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.enableVoicePitch = false;
        this.interval = interval;
        this.enableSpectrum = enableSpectrum;
        this.enableVad = enableVad;
        this.localMainReportMode = localMainReportMode;
        this.smooth = smooth;
    }

    public String toString() {
        return "AudioPropertiesConfig{interval='" + this.interval + "'enable_spectrum='" + this.enableSpectrum + "'enable_vad='" + this.enableVad + "'local_main_report_mode='" + this.localMainReportMode + "'audio_report_mode='" + this.audioReportMode.toString() + "'enable_voice_pitch='" + this.enableVoicePitch + "'}";
    }
}
