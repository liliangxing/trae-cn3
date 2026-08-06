package com.bytedance.webx.seclink.setting;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class SettingConfig {
    public static final String SPECIAL_SCHEME = "*";
    public Config config;
    public Global global;
    public Map<String, SceneConfig> sceneCfgMap;

    /* loaded from: classes6.dex */
    public static class Config {
        public boolean custom_settings_biz_first = true;
        public int error_overwhelming_count;
        public long error_overwhelming_duration;
        public long period;
        public long safe_duration_after_overwhelming;
        public String seclink_settings_version;
        public List<String> settings_url_array;
        public double sync_check_time_limit;
        public boolean use_cache;
        public List<String> verify_host_array;
    }

    /* loaded from: classes6.dex */
    public static class Global {
        public boolean async_mode;
        public boolean enable;
        public Set<String> scheme;
        public boolean use_verify_mode_v2;
    }

    public String toString() {
        return "SettingConfig{common=" + this.config + ", scenes=" + this.sceneCfgMap + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes6.dex */
    public static class SceneConfig {
        public boolean async_mode;
        public boolean enable;
        public String name;
        public Set<String> scheme;
        public boolean use_verify_mode_v2;

        public String toString() {
            return "SceneConfig{name='" + this.name + "', enable=" + this.enable + ", async_mode=" + this.async_mode + ", scheme=" + this.scheme + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
