package com.ss.android.socialbase.downloader.setting;

/* loaded from: classes7.dex */
public interface DownloadSettingKeys {
    public static final String ACTIVE_LOAD_DOWNLOAD_CACHE = "active_load_download_cache";
    public static final String APK_PARSER_ZIP_FILE = "apk_parser_zip_file_type";
    public static final String AUTO_CLEAN_DIRECTORY = "auto_clean_directory";
    public static final String AUTO_RESUME = "auto_resume";
    public static final String BIZ_CLOSE_DB_BATCH_INIT = "biz_close_db_batch_init";
    public static final String BUG_FIX = "bugfix";
    public static final String CANCEL_WITH_NET_OPT = "cancel_with_net_opt";
    public static final String CLEANER_BACKGROUND_HIGH_MEMORY_STOP = "cleaner_background_high_memory_stop";
    public static final String CLEANER_BACKGROUND_SINGLE_LOAD_COUNT_LIMIT = "cleaner_background_single_load_count_limit";
    public static final String CLEANER_BACKGROUND_SINGLE_LOAD_SLEEP_TIME_MS = "cleaner_background_single_load_sleep_time_ms";
    public static final String CLEAN_DIRECTORY_CHECK_INTERVAL_D = "clean_directory_check_interval_d";
    public static final String CLEAN_DIRECTORY_EXPIRED_TIME_D = "clean_directory_expired_time_d";
    public static final String CLEAN_DIRECTORY_LIST = "clean_directory_list";
    public static final String CLEAN_INSTALLED_APK = "clean_installed_apk";
    public static final String CONNECT_TIMEOUT = "connect_timeout";
    public static final String DB_INIT_MONITOR_SCENE_LIST = "db_init_monitor_scene_list";
    public static final String DEBUG = "debug";
    public static final String DEFAULT_SAVE_DIR_NAME = "default_save_dir_name";
    public static final String DELAY_INIT_DOWNLOAD_CACHE_MS = "delay_init_download_cache_ms";
    public static final String DELAY_REFRESH_UNSUCCESS_TASK_MS = "delay_refresh_unsuccess_task_ms";
    public static final String DELETE_APK_DURATION_INSTALL_TIME_DELAY_S = "delete_apk_duration_install_time_delay_s";
    public static final String DISABLED_TASK_KEYS = "disabled_task_keys";
    public static final String DISABLE_CHECK_NO_NETWORK = "disable_check_no_network";
    public static final String DISABLE_TASK_SETTING = "disable_task_setting";
    public static final String DNS_EXPIRE_MIN = "dns_expire_min";
    public static final String DOWNLOADER_ALOG_LEVEL = "downloader_alog_level";
    public static final String DOWNLOADER_ALOG_TASK_SCENE_LIST = "downloader_alog_task_scene_list";
    public static final String DOWNLOADER_LOGGER_GLOBAL_REPORT = "downloader_logger_global_report";
    public static final String DOWNLOADER_LOGGER_TASK_REPORT_SCENE_LIST = "downloader_logger_task_report_scene_list";
    public static final String DOWNLOADING_TASK_ANR_SLEEP_PROHIBIT_SCENE_LIST = "downloading_task_anr_sleep_prohibit_scene_list";
    public static final String DOWNLOADING_TASK_ANR_SLEEP_TIME_S = "downloading_task_anr_sleep_time_s";
    public static final String DOWNLOAD_DB_INIT_OPTIMIZE = "download_db_init_optimize";
    public static final String DOWNLOAD_FAILED_CHECK_NET = "download_failed_check_net";
    public static final String DOWNLOAD_FINISH_CHECK_TTMD5 = "download_finish_check_ttmd5";
    public static final String DOWNLOAD_VIDS = "download_vids";
    public static final String DOWNLOAD_WHEN_SPACE_NEGATIVE = "download_when_space_negative";
    public static final String ENABLE_APP_PACKAGE_INFO_CACHE = "enable_app_package_info_cache";
    public static final String ENABLE_DOWNLOAD_NETWORK_TAG = "enable_download_network_tag";
    public static final String ENABLE_EXTERNAL_DOWNLOAD = "enable_external_download";
    public static final String ENABLE_PLUGIN_DOWNLOAD_OPT = "enable_plugin_download_opt";
    public static final String ENABLE_REMOVE_DOWNLOAD_SP_INFO = "enable_remove_download_sp_info";
    public static final String ENABLE_REPLACE_EXTERNAL_PATH = "enable_replace_external_path";
    public static final String ENABLE_SETTING_CACHE = "enable_setting_cache";
    public static final String ENABLE_TARGET_34 = "enable_target_34";
    public static final String FAST_DOWNLOAD_CLEAN_TEMP_PATH_DELAY_TIME_S = "fast_download_clean_temp_path_delay_time_S";
    public static final String FAST_DOWNLOAD_THREAD_POOL_SIZE_LIMIT = "fast_download_thread_pool_size_limit";
    public static final String FILE_PROVIDER_AUTHORITY = "file_provider_authority";
    public static final String FIX_ANR_ISOLATE_ENGINE_AND_CACHE = "fix_anr_isolate_engine_and_cache";
    public static final String FIX_ANR_PROGRESS_HANDLE_MSG = "fix_anr_progress_handle_msg";
    public static final String FIX_ANR_REMOVE_REPORT_IDLE_STATUS = "fix_anr_remove_report_idle_status";
    public static final String FIX_NOTIFICATION_LEAK = "fix_notification_leak";
    public static final String FIX_SAME_TASK_MONITOR_REPORT = "fix_same_task_monitor_report";
    public static final String FIX_SAVE_EXTERNAL_DIR = "fix_save_external_dir";
    public static final String FIX_SQLITE_UPGRADE_FAIL_CALLBACK = "fix_sqlite_upgrade_fail_callback";
    public static final String FIX_TASK_REPETITION = "fix_task_repetition";
    public static final String FIX_VULNERABILITY_CSRF = "fix_vulnerability_csrf";
    public static final String FIX_VULNERABILITY_FILE_NAME = "fix_vulnerability_file_name";
    public static final String FLUSH_BUFFER_SIZE_BYTE = "flush_buffer_size_byte";
    public static final String FORCE_CHECK_FILE_LENGTH = "force_check_file_length";
    public static final String FORCE_INDEPENDENT_PROCESS = "force_independent_process";
    public static final String FORCE_MAIN_PROCESS = "force_main_process";
    public static final String GLOBAL_TASK_SETTING = "global_task_setting";
    public static final String INCOMPLETE_FILE_EXPIRED_TIME = "incomplete_file_expired_time";
    public static final String INIT_DOWNLOAD_CACHE_TIMEOUT_MS = "init_download_cache_timeout_ms";
    public static final String IO_TIMEOUT = "io_timeout";
    public static final String KEY_AH_PLANS = "ah_plans";
    public static final String KEY_ANTI_HIJACK_DIR = "download_dir";
    public static final String KEY_APP_INSTALL_RETURN_RESULT = "app_install_return_result";
    public static final String KEY_EXCEPTION_MSG_LENGTH = "exception_msg_length";
    public static final String KEY_GLOBAL_THREAD_POOL_OPT = "global_thread_pool_opt";
    public static final String KEY_HOT_CACHE_KEYS = "lru_preload_hot_cache_keys";
    public static final String KEY_IS_CHECK_CACHE_ENABLE = "is_check_cache_enable";
    public static final String KEY_IS_GLOBAL_THROTTLE_ENABLE = "global_throttle_enable";
    public static final String KEY_LRU_CAPACITY_MAX = "lru_download_info_capacity_max";
    public static final String KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE = "lru_download_info_cache_enable";
    public static final String KEY_SET_NOTIFICATION_GROUP = "set_notification_group";
    public static final String KEY_THROTTLE_THREAD_POOL_OPT = "throttle_thread_pool_opt";
    public static final String LOAD_DB_WAIT_TIME_MS = "load_db_wait_time_ms";
    public static final String LRU_DB_INIT_MONITOR_SCENE_LIMIT_LIST = "lru_db_init_monitor_scene_limit_list";
    public static final String MAIN_THREAD_DB_OP_MAX_TIME_MS = "main_thread_db_op_max_time_ms";
    public static final String MONITOR_CACHE_DELAY_TIME_S = "monitor_cache_delay_time_s";
    public static final String MONITOR_CACHE_INTERVAL_D = "monitor_cache_interval_d";
    public static final String MONITOR_CACHE_PATH_LIST = "monitor_cache_path_list";
    public static final String MONITOR_CACHE_TOP_COUNT = "monitor_cache_top_count";
    public static final String MONITOR_DOWNLOAD_CONNECT = "monitor_download_connect";
    public static final String MONITOR_DOWNLOAD_IO = "monitor_download_io";
    public static final String MONITOR_RW = "monitor_rw";
    public static final String MONITOR_SEGMENT_IO = "monitor_segment_io";
    public static final String MONITOR_SLA = "monitor_sla";
    public static final String NETWORK_FAILOVER_STRATEGY = "network_failover_strategy";
    public static final String NET_LIB_STRATEGY = "net_lib_strategy";
    public static final String NOTIFICATION_TEXT_OPT = "notification_text_opt";
    public static final String NOTIFICATION_TIME_WINDOW = "notification_time_window";
    public static final String NO_NET_OPT = "no_net_opt";
    public static final String OPTIMIZE_DOWNLOAD_CACHE = "optimize_download_cache";
    public static final String OPTIMIZE_DOWNLOAD_DB_LOAD = "optimize_download_db_load";
    public static final String OPT_MKDIR_FAILED = "opt_mkdir_failed";
    public static final String OPT_NOTIFICATION_UI = "enable_notification_ui";
    public static final String PARSE_PACKAGE_INFO_BY_READ_FILE_MODE = "parse_package_info_by_read_file_mode";
    public static final String PCDN_CONFIG = "pcdn_config";
    public static final String PLUGIN_DEGRADE_BACKUP_TIMEOUT_S = "plugin_degrade_backup_timeout_s";
    public static final String PLUGIN_THREAD_POOL_SIZE = "plugin_thread_pool_size";
    public static final String REMOVE_DOWNLOAD_SUCCESS_AND_NOT_EXISTS = "remove_download_success_and_not_exists";
    public static final String REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q = "remove_external_public_dir_task_for_q";
    public static final String REMOVE_USELESS_MONITOR_REPORT = "remove_useless_monitor_report";
    public static final String REPLACE_DOWNLOAD_TASK_PARAM = "replace_download_task_param";
    public static final String REPORT_SPACE_GRAIN_SIZE = "report_space_grain_size";
    public static final String RETRY_SCHEDULE = "retry_schedule";
    public static final String RETRY_SCHEDULE_CONFIG = "retry_schedule_config";
    public static final String RETRY_STRATEGY = "retry_strategy";
    public static final String RUN_CLEANER_BACKGROUND_DELAY_TIME_S = "run_cleaner_background_delay_time_s";
    public static final String SAVE_PATH_INVALID_DOWNGRADE = "save_path_invalid_downgrade";
    public static final String SEGMENT_CONFIG = "segment_config";
    public static final String SEGMENT_NIO = "segment_nio";
    public static final String SETTING_TAG = "setting_tag";
    public static final String SINGLE_ASYNC_HANDLE_OPERATION = "single_async_handle_operation";
    public static final String SKIP_DB_INIT_EXPECT_MIME_TYPE = "skip_db_init_expect_mime_type";
    public static final String SKIP_DB_INIT_MONITOR_SCENE_LIST = "skip_db_init_monitor_scene_list";
    public static final String SPACE_FILL_MIN_KEEP_MB = "space_fill_min_keep_mb";
    public static final String SPACE_FILL_PART_DOWNLOAD = "space_fill_part_download";
    public static final String SQLITE_UPGRADE_FAIL_DROP_TABLE = "sqlite_upgrade_fail_drop_table";
    public static final String SQLITE_UPGRADE_IGNORE_DUPLICATE_COLUMN = "sqlite_upgrade_ignore_duplicate_column";
    public static final String SQL_DOWNLOAD_CACHE_INIT_SINGLE_LOAD_COUNT_LIMIT = "sql_download_cache_init_single_load_count_limit";
    public static final String SQL_DOWNLOAD_CACHE_INIT_SINGLE_LOAD_SLEEP_TIME_MS = "sql_download_cache_init_single_load_sleep_time_ms";
    public static final String SQL_DOWNLOAD_CACHE_TIME_OPT = "sql_download_cache_time_opt";
    public static final String SUPPORT_SQLITE_DOWNGRADE = "support_sqlite_downgrade";
    public static final String SYNC_INTERVAL_MS_BG = "sync_interval_ms_bg";
    public static final String SYNC_INTERVAL_MS_FG = "sync_interval_ms_fg";
    public static final String SYNC_MIN_LENGTH = "sync_min_length";
    public static final String SYNC_STRATEGY = "sync_strategy";
    public static final String THREAD_LOAD_DOWNLOAD_CACHE_ONLY_ONCE = "thread_load_download_cache_only_once";
    public static final String THROTTLE_FACTOR_MAX = "throttle_factor_max";
    public static final String THROTTLE_FACTOR_MIN = "throttle_factor_min";
    public static final String TTNET_ERROR_BODY_LENGTH_LIMIT = "ttnet_error_body_length_limit";
    public static final String TTNET_ERROR_PROTO_TYPE = "ttnet_proto_type";
    public static final String UNCHECK_EXTERNAL_PUBLIC_DIR = "uncheck_external_public_dir";
    public static final String URL_INTERCEPT_CONFIG = "url_intercept_config";

    @Deprecated
    public static final String USE_DEFAULT_THROTTLE_SPEED = "use_default_throttle_speed";
    public static final String USE_HOST_DNS = "use_host_dns";
    public static final String USE_NETWORK_CALLBACK = "use_network_callback";
    public static final String VERIFY_RESPONSE_PRE_FILE_LENGTH = "verify_response_pre_file_length";

    /* loaded from: classes7.dex */
    public interface AhPlans {
        public static final String KEY_AH_DEVICE_PLANS = "device_plans";
        public static final String KEY_AH_DEVICE_REQUIREMENTS = "device_requirements";
        public static final String KEY_AH_DEVICE_ROM = "device_rom";
        public static final String KEY_AH_PLAN_TYPE = "type";
        public static final String KEY_ALLOW_OS_API_RANGE = "allow_os_api_range";
        public static final String KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP = "show_unknown_source_on_startup";
        public static final String KEY_DYNAMIC_MODE = "dynamic_mode";
        public static final String KEY_JUMP_INTERVAL = "jump_interval";
        public static final String KEY_JUMP_INTERVAL_BY_SEQ = "jump_interval_by_seq";
        public static final String KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL = "enable_for_all";
        public static final String KEY_JUMP_UNKNOWN_SOURCE_TIPS = "jump_unknown_source_tips";
        public static final String KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL = "query_interval";
        public static final String KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT = "time_out_second";
        public static final String KEY_MIN_OS_API = "min_os_api";
        public static final String KEY_SECURITY_MODE = "scy_mode";
        public static final String KEY_SHOW_TIPS = "show_tips";
        public static final String KEY_SHOW_UNKNOWN_SOURCE_DIALOG = "show_unknown_source_dialog";

        /* loaded from: classes7.dex */
        public interface DeviceRequirements {
            public static final String KEY_ALLOW_VERSION_RANGE = "allow_version_range";
            public static final String KEY_ANTI_HIJACK_PACKAGE_NAMES = "package_names";
            public static final String KEY_ANTI_HIJACK_VERSION_ALLOW = "version_allow";
            public static final String KEY_ANTI_HIJACK_VERSION_BLOCK = "version_block";
        }
    }

    /* loaded from: classes7.dex */
    public interface AntiHijackDir {
        public static final String KEY_ANTI_HIJACK_DIR_NAME = "dir_name";
        public static final String KEY_ANTI_HIJACK_INSTALL_DESC = "ins_desc";
        public static final String KEY_IGNORE_TASK_SAVE_PATH = "ignore_task_save_path";
        public static final String SAVE_LOCATION = "save_location";
    }

    /* loaded from: classes7.dex */
    public interface BugFix {
        public static final String DEFAULT = "default";
        public static final String FIX_BACKGROUND_NOTIFICATION = "fix_background_notification";
        public static final String FIX_CALLBACK_DEADLOCK = "fix_callback_deadlock";
    }

    /* loaded from: classes7.dex */
    public interface CacheCleaner {
        public static final String ASYNC_DB_CLEAN = "async_db_clean";
        public static final String CLEAN_GROUP = "clean_group";
        public static final String CLEAN_ID = "clean_id";
        public static final String CLEAN_INTERVAL_D = "clean_interval_d";
        public static final String MONITOR_SCENE_LIST = "monitor_scene_list";
        public static final String SAVE_PATH_LIST = "save_path_list";
        public static final String START_CLEAN_DELAY_TIME_S = "start_clean_delay_time_s";
        public static final String URL_PREFIX_LIST = "url_prefix_list";
    }

    /* loaded from: classes7.dex */
    public interface CleanDirectory {
        public static final String DIRECTORY_PATH = "directory_path";
        public static final String PATH_CONTAINS_LIST = "path_contains_list";
    }

    /* loaded from: classes7.dex */
    public interface DownloadTaskParam {
        public static final String ADD_TTNET_COMMON_PARAM = "add_ttnet_common_param";
        public static final String AUTO_REMOVE_CALLBACK = "auto_remove_callback";
        public static final String DISTINCT_DIRECTORY = "distinct_directory";
        public static final String EXECUTOR_GROUP = "executor_group";
        public static final String EXTRA = "extra";
        public static final String EXTRA_HEADERS = "extra_headers";
        public static final String FAST_DOWNLOAD = "fast_download";
        public static final String FORCE = "force";
        public static final String IGNORE_INTERCEPTOR = "ignore_interceptor";
        public static final String INNER_SAVE_PATH = "inner_save_path";
        public static final String MAX_BYTES = "max_bytes";
        public static final String ONLY_WIFI = "only_wifi";
        public static final String RETRY_COUNT = "retry_count";
        public static final String SHOW_NOTIFICATION = "show_notification";
        public static final String SHOW_NOTIFICATION_FOR_AUTO_RESUMED = "show_notification_for_auto_resumed";
        public static final String TTNET_PROTECT_TIMEOUT = "ttnet_protect_timeout";
    }

    /* loaded from: classes7.dex */
    public interface NetworkFailoverStrategy {
        public static final String KEY_TTNET_BACK_HOST = "ttnet_back_host";
        public static final String KEY_TTNET_BACK_HOST_COUNT_LIMIT = "ttnet_back_host_count_limit";
        public static final String KEY_TTNET_BACK_HOST_ERROR_CODE = "ttnet_back_host_error_code";
        public static final String KEY_TTNET_IP_CHANGE_COUNT_LIMIT = "ttnet_ip_change_count_limit";
        public static final String KEY_TTNET_IP_CHANGE_ERROR_CODE = "ttnet_ip_change_error_code";
        public static final String KEY_TTNET_ISOLATION_COUNT = "ttnet_isolation_count";
        public static final String KEY_TTNET_ISOLATION_ERROR_CODE = "ttnet_isolation_error_code";
        public static final String KEY_TTNET_ISOLATION_HTTP_PROTO_TYPE = "ttnet_isolation_http_proto_type";
        public static final String KEY_TTNET_TIMEOUT_CONNECT = "ttnet_timeout_connect";
        public static final String KEY_TTNET_TIMEOUT_ERROR_CODE = "ttnet_timeout_error_code";
        public static final String KEY_TTNET_TIMEOUT_IO = "ttnet_timeout_io";
    }

    /* loaded from: classes7.dex */
    public interface PCDNConfig {
        public static final String CHUNK_RETRY_COUNT = "chunk_retry_count";
        public static final String MAX_CHUNK_LENGTH = "max_chunk_length";
        public static final String PCDN_DEGRADE_BANDWIDTH_LIMIT = "pcdn_degrade_bandwidth_limit";
        public static final String PCDN_DEGRADE_SAMPLE_COUNT = "pcdn_degrade_sample_count";
        public static final String THREAD_COUNT = "thread_count";
    }

    /* loaded from: classes7.dex */
    public interface RetryScheduleConfig {
        public static final String ALLOW_ERROR_CODE = "allow_error_code";
        public static final String INTERVAL_SEC = "interval_sec";
        public static final String INTERVAL_SEC_ACCELERATION = "interval_sec_acceleration";
        public static final String MAX_COUNT = "max_count";
        public static final String USE_JOB_SCHEDULER = "use_job_scheduler";
    }

    /* loaded from: classes7.dex */
    public interface RetryStrategy {
        public static final String KEY_DELAY_INTERVAL_MS = "delay_interval_ms";
        public static final String KEY_RETRY_COUNT = "retry_count";
        public static final String KEY_RETRY_COUNT_LIMIT_PERIOD = "retry_count_limit_period";
        public static final String KEY_RETRY_PERIOD_MS = "retry_period_ms";
        public static final String KEY_RETRY_RESET_COUNT_LIMIT = "retry_reset_count_limit";
    }

    /* loaded from: classes7.dex */
    public interface SegmentConfig {
        public static final String BUFFER_COUNT = "buffer_count";
        public static final String BUFFER_SIZE = "buffer_size";
        public static final String CONNECT_TIMEOUT = "connect_timeout";
        public static final String ENABLE_TTNET_IP_REQUEST = "enable_ttnet_ip_request";
        public static final String EXPECT_MIN_DOWNLOAD_SIZE = "expect_min_download_size";
        public static final String IP_STRATEGY = "ip_strategy";
        public static final String MAIN_RATIO = "main_ratio";
        public static final String POOR_SPEED_RATIO = "poor_speed_ratio";
        public static final String RATIO_SEGMENT = "ratio_segment";
        public static final String READ_TIMEOUT = "read_timeout";
        public static final String SEGMENT_MAX_KB = "segment_max_kb";
        public static final String SEGMENT_MIN_INIT_MB = "segment_min_init_mb";
        public static final String SEGMENT_MIN_KB = "segment_min_kb";
        public static final String SEGMENT_MODE = "segment_mode";
        public static final String THREAD_COUNT = "thread_count";
        public static final String URL_BALANCE = "url_balance";
    }

    /* loaded from: classes7.dex */
    public interface UrlInterceptConfig {
        public static final String HOST_LIST = "host_list";
        public static final String PATH_LIST = "path_list";
        public static final String PATTERN_LIST = "pattern_list";
    }
}
