package com.bytedance.ies.web.jsbridge2;

import android.os.SystemClock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class TimeLineEvent implements Serializable {
    private final long elapsedTimestamp;
    private final HashMap<String, Object> extra;
    private final String label;
    private final String message;
    private final String time;
    private final long timeInMillis;

    /* loaded from: classes4.dex */
    public static class Constants {
        public static String ABOUT_BLANK = "about:blank";
        public static String CALL_PERMISSION_GROUP = "call_permission_group";
        public static String CONFIG = "config";
        public static String CONFIG_SIZE = "config_size";
        public static String DISABLE_ALL_PERMISSION_CHECK = "disable_all_permission_check";
        public static String ENABLE_PERMISSION_CHECK = "enable_permission_check";
        public static String EXCEPTION_MESSAGE = "exception_message";
        public static String EXCEPTION_NAME = "exception_name";
        public static String FALSE = "false";
        public static String FETCH_PERMISSION_CONFIG = "fetch_permission_config";
        public static String FILTER_URL = "filter_url";
        public static String FROM = "from";
        public static String FROM_CACHE = "from_cache";
        public static String FROM_CREATE = "from_create";
        public static String FROM_INJECTION = "from_injection";
        public static String FROM_MERGE = "from_merge";
        public static String FROM_NETWORK = "from_network";
        public static String FROM_STORAGE = "from_storage";
        public static String HOST = "host";
        public static String KEY = "key";
        public static String LABEL_ABSTRACT_BRIDGE_REJECT = "label_abstract_bridge_reject";
        public static String LABEL_CALLBACK_URL_CHANGED = "label_callback_url_changed";
        public static String LABEL_CALL_HANDLER_REJECT = "label_call_handler_reject";
        public static String LABEL_CALL_NEW_URL = "label_call_new_url";
        public static String LABEL_CALL_ORIGIN_URL = "label_call_origin_url";
        public static String LABEL_CALL_PENDING = "label_call_pending";
        public static String LABEL_CREATE_CALL_HANDLER = "label_create_call_handler";
        public static String LABEL_CREATE_FETCH_PARAM_EXCEPTION = "label_create_fetch_param_exception";
        public static String LABEL_CREATE_JAVA_CALL = "label_create_java_call";
        public static String LABEL_CREATE_JSB_ENVIRONMENT = "label_create_jsb_environment";
        public static String LABEL_CREATE_JSB_INSTANCE = "label_create_jsb_instance";
        public static String LABEL_ENABLE_PERMISSION_CHECK = "label_enable_permission_check";
        public static String LABEL_FETCH_ON_FAILED = "label_fetch_on_failed";
        public static String LABEL_ILLEGAL_NAMESPACE = "label_illegal_namespace";
        public static String LABEL_INVALID_CALLBACK_ID = "label_invalid_callback_id";
        public static String LABEL_PARSE_CONFIG = "label_parse_config";
        public static String LABEL_PARSE_CONFIG_EXCEPTION = "label_parse_config_exception";
        public static String LABEL_PARSE_PACKAGE_VERSION = "label_parse_package_version";
        public static String LABEL_PENDING_CALL_LIST = "label_pending_call_list";
        public static String LABEL_PERMISSION_CHECKER = "label_permission_checker";
        public static String LABEL_PERMISSION_CHECKER_CACHE_RULE = "label_permission_checker_cache_rule";
        public static String LABEL_PERMISSION_CHECKER_FETCH = "label_permission_checker_fetch";
        public static String LABEL_PERMISSION_CHECKER_FILTER_URL = "label_permission_checker_filter_url";
        public static String LABEL_PERMISSION_CHECKER_MERGE_REMOTE_CONFIG = "label_permission_checker_merge_remote_config";
        public static String LABEL_PERMISSION_CHECKER_NULL_CONFIG = "label_permission_checker_null_config";
        public static String LABEL_PERMISSION_CHECKER_NULL_HOST = "label_permission_checker_null_host";
        public static String LABEL_PERMISSION_CHECKER_PUBLIC_METHOD = "label_permission_public_method";
        public static String LABEL_PERMISSION_CHECKER_REMOTE_CONFIG = "label_permission_checker_remote_config";
        public static String LABEL_PERMISSION_CHECKER_RESULT = "label_permission_checker_result";
        public static String LABEL_PERMISSION_CHECKER_SAFE_HOST = "label_permission_checker_safe_host";
        public static String LABEL_PERMISSION_CHECKER_VALIDATOR = "label_permission_checker_validator";
        public static String LABEL_PERMISSION_STORAGE = "label_permission_storage";
        public static String LABEL_POST_CALLBACK_ORIGIN_URL = "label_post_callback_origin_url";
        public static String LABEL_PRE_CALLBACK_ORIGIN_URL = "label_pre_callback_origin_url";
        public static String LABEL_PRE_CALL_ORIGIN_URL = "label_pre_call_origin_url";
        public static String LABEL_PRE_HANDLE_ORIGIN_URL = "label_pre_handle_origin_url";
        public static String LABEL_REPOSITORY_CREATE_CONFIG = "label_repository_create_config";
        public static String LABEL_REPOSITORY_MERGE_CONFIG_EXCEPTION = "label_repository_merge_config_exception";
        public static String LABEL_REPOSITORY_PARSE_CONFIG = "label_repository_parse_config";
        public static String LABEL_REPOSITORY_PARSE_CONFIG_EXCEPTION = "label_repository_parse_config_exception";
        public static String LABEL_REPOSITORY_UPDATE_CONFIG = "label_repository_update_config";
        public static String LIST = "list";
        public static String METHOD_CLASS = "method_class";
        public static String METHOD_NAME = "method_name";
        public static String METHOD_PERMISSION_GROUP = "method_permission_group";
        public static String NAMESPACE = "namespace";
        public static String NULL = "null";
        public static String PARAM = "param";
        public static String PERMISSION_CONFIG_REPOSITORY = "permission_config_repository";
        public static String PUBLIC_METHOD_SET = "public_method_set";
        public static String REASON = "reason";
        public static String REASON_ABOUT_BLANK_1 = "about_blank_1";
        public static String REASON_ABOUT_BLANK_2 = "about_blank_2";
        public static String REASON_CALL_INVALID_1 = "call_invalid_1";
        public static String REASON_CALL_INVALID_2 = "call_invalid_2";
        public static String REASON_NOT_REGISTERED_1 = "not_registered_1";
        public static String REASON_NOT_REGISTERED_2 = "not_registered_2";
        public static String REASON_PARAMS_INVALID = "params_invalid";
        public static String REASON_PERMISSION_EMPTY_1 = "permission_empty_1";
        public static String REASON_PERMISSION_EMPTY_2 = "permission_empty_2";
        public static String REASON_UNKNOWN_NAMESPACE = "unknown_namespace";
        public static String REASON_URL_EMPTY = "url_empty";
        public static String REPO_FETCHED = "config_repository_fetched";
        public static String RESPONSE = "response";
        public static String RULE_EXCLUDED_METHOD = "rule_excluded_method";
        public static String RULE_INCLUDED_METHOD = "rule_included_method";
        public static String RULE_PERMISSION_GROUP = "rule_permission_group";
        public static String SAFE_HOST_SET = "safe_host_set";
        public static String SHORTENED_HOST = "shortened_host";
        public static String TRUE = "true";
        public static String URL = "url";
        public static String VALIDATOR_CHECK = "validator_check";
        public static String VALUE = "value";
    }

    private TimeLineEvent(Builder builder) {
        this.label = builder.label;
        this.message = builder.message;
        this.time = builder.time;
        this.extra = builder.extra;
        this.elapsedTimestamp = builder.elapsedTimestamp;
        this.timeInMillis = builder.timeInMillis;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTime() {
        return this.time;
    }

    public long getTimeInMillis() {
        return this.timeInMillis;
    }

    public long getElapsedTimestamp() {
        return this.elapsedTimestamp;
    }

    public HashMap<String, Object> getExtra() {
        return this.extra;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);
        private long elapsedTimestamp;
        private HashMap<String, Object> extra;
        private String label;
        private String message;
        private String time;
        private long timeInMillis;

        public static Builder instance() {
            return new Builder();
        }

        public Builder setLabel(String str) {
            this.label = str;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setTime(String str) {
            this.time = str;
            return this;
        }

        public Builder setTimeInMillis(long j) {
            this.timeInMillis = j;
            return this;
        }

        public Builder setTime() {
            this.time = this.dateTimeFormatter.format(new Date());
            this.elapsedTimestamp = SystemClock.elapsedRealtime();
            this.timeInMillis = System.currentTimeMillis();
            return this;
        }

        public Builder setExtra(HashMap<String, Object> hashMap) {
            this.extra = hashMap;
            return this;
        }

        public Builder setExtraItem(String str, Object obj) {
            if (this.extra == null) {
                this.extra = new HashMap<>();
            }
            this.extra.put(str, obj);
            return this;
        }

        public TimeLineEvent build() {
            return new TimeLineEvent(this);
        }

        public TimeLineEvent bind(String str, List<TimeLineEvent> list) {
            TimeLineEvent build = setTime().setLabel(str).build();
            if (list != null) {
                list.add(build);
            }
            return build;
        }
    }
}
