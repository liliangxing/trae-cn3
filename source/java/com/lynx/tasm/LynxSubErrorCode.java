package com.lynx.tasm;

import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class LynxSubErrorCode {
    public static final int E_APP_BUNDLE_LOAD_BAD_BUNDLE = 10205;
    public static final int E_APP_BUNDLE_LOAD_BAD_RESPONSE = 10203;
    public static final int E_APP_BUNDLE_LOAD_ENV_NOT_READY = 10202;
    public static final int E_APP_BUNDLE_LOAD_EXCEPTION = 10299;
    public static final int E_APP_BUNDLE_LOAD_PARSE_FAILED = 10204;
    public static final int E_APP_BUNDLE_LOAD_RENDER_FAILED = 10201;
    public static final int E_APP_BUNDLE_RELOAD_EARLY_RELOAD = 10501;
    public static final int E_APP_BUNDLE_VERIFY_INVALID_SIGNATURE = 10701;
    public static final int E_BTS_LIFECYCLE_LISTENER_ERROR_EXCEPTION = 20301;
    public static final int E_BTS_PLATFORM_CALL_JS_FUNCTION_TOO_FREQUENCY = 20201;
    public static final int E_BTS_RUNTIME_ERROR = 20100;
    public static final int E_BTS_RUNTIME_ERROR_BINDINGS_ERROR = 20103;
    public static final int E_BTS_RUNTIME_ERROR_BYTECODE_SCRIPT_ERROR = 20102;
    public static final int E_BTS_RUNTIME_ERROR_SCRIPT_ERROR = 20101;
    public static final int E_COMPONENT_API_DEPRECATED = 220101;
    public static final int E_COMPONENT_CUSTOM = 229800;
    public static final int E_COMPONENT_IMAGE_UNSUPPORTED_PROP = 220301;
    public static final int E_COMPONENT_LIST_CELL_NOT_FOUND = 220203;
    public static final int E_COMPONENT_LIST_CHILD_COMPONENT_NOT_EXIST = 220206;
    public static final int E_COMPONENT_LIST_DUPLICATED_CELL = 220202;
    public static final int E_COMPONENT_LIST_DUPLICATE_ITEM_KEY = 220208;
    public static final int E_COMPONENT_LIST_DYNAMIC_CHANGE_ORIENTATION = 220204;
    public static final int E_COMPONENT_LIST_ILLEGAL_ITEM_KEY = 220201;
    public static final int E_COMPONENT_LIST_INVALID_PROPS_ARG = 220205;
    public static final int E_COMPONENT_LIST_SET_UPDATE_ANIMATION_MULTIPLE_TIMES = 220209;
    public static final int E_COMPONENT_LIST_UNSUPPORTED_THREAD_STRATEGY = 220207;
    public static final int E_CSS = 130100;
    public static final int E_CSS_COMPUTED_CSS_VALUE_UNKNOWN_GETTER = 130202;
    public static final int E_CSS_COMPUTED_CSS_VALUE_UNKNOWN_SETTER = 130201;
    public static final int E_CSS_COMPUTED_CSS_VALUE_UNSUPPORTED_INHERITANCE = 130203;
    public static final int E_CSS_PARSER = 130300;
    public static final int E_CSS_UNKNOWN_PROPERTY = 130101;
    public static final int E_CSS_UNSUPPORTED_VALUE = 130102;
    public static final int E_DATA_FLOW_UPDATE_EXCEPTION = 40199;
    public static final int E_DATA_FLOW_UPDATE_INVALID_PROCESSOR = 40101;
    public static final int E_DATA_FLOW_UPDATE_INVALID_TYPE = 40102;
    public static final int E_ELEMENT_API_ERROR = 50102;
    public static final int E_ELEMENT_API_FATAL = 50101;
    public static final int E_ELEMENT_UPDATE_NODE_IS_NULL = 50201;
    public static final int E_EVENT_EXCEPTION = 109900;
    public static final int E_EXCEPTION_JNI = 990200;
    public static final int E_EXCEPTION_PLATFORM = 990100;
    public static final int E_LAYOUT_INTERNAL = 60100;
    public static final int E_LAYOUT_PERF_INFINITE_LOOP = 60201;
    public static final int E_LAYOUT_PLATFORM_NODE_NULL = 60401;
    public static final int E_LAYOUT_UPDATE_UI_NOT_FOUND = 60301;
    public static final int E_LAZY_BUNDLE_LOAD_BAD_BUNDLE = 160104;
    public static final int E_LAZY_BUNDLE_LOAD_BAD_RESPONSE = 160101;
    public static final int E_LAZY_BUNDLE_LOAD_DECODE_FAILED = 160103;
    public static final int E_LAZY_BUNDLE_LOAD_EMPTY_FILE = 160102;
    public static final int E_MTS_BRIDGE_MODULE_WRONG_PARAM = 200101;
    public static final int E_MTS_RENDERER_FUNCTION_ERROR = 111102;
    public static final int E_MTS_RENDERER_FUNCTION_FATAL = 111101;
    public static final int E_MTS_RUNTIME_ERROR = 110100;
    public static final int E_NATIVE_MODULES_COMMON_AUTHORIZATION_ERROR = 90105;
    public static final int E_NATIVE_MODULES_COMMON_DEPRECATED = 90108;
    public static final int E_NATIVE_MODULES_COMMON_FUNCTION_NOT_FOUND = 90102;
    public static final int E_NATIVE_MODULES_COMMON_MODULE_NOT_FOUND = 90101;
    public static final int E_NATIVE_MODULES_COMMON_RETURN_ERROR = 90107;
    public static final int E_NATIVE_MODULES_COMMON_SYSTEM_AUTHORIZATION_ERROR = 90106;
    public static final int E_NATIVE_MODULES_COMMON_WRONG_PARAM_NUM = 90103;
    public static final int E_NATIVE_MODULES_COMMON_WRONG_PARAM_TYPE = 90104;
    public static final int E_NATIVE_MODULES_CUSTOM_ERROR = 99800;
    public static final int E_NATIVE_MODULES_EXCEPTION = 99900;
    public static final int E_NATIVE_MODULES_NETWORK_BAD_RESPONSE = 90801;
    public static final int E_RESOURCE_CUSTOM = 39800;
    public static final int E_RESOURCE_EXCEPTION = 39900;
    public static final int E_RESOURCE_EXTERNAL_RESOURCE_LOCAL_RESOURCE_LOAD_FAIL = 30302;
    public static final int E_RESOURCE_EXTERNAL_RESOURCE_REQUEST_FAILED = 30301;
    public static final int E_RESOURCE_FONT = 30200;
    public static final int E_RESOURCE_FONT_BASE64_PARSING_ERROR = 30203;
    public static final int E_RESOURCE_FONT_FILE_FORMAT_NOT_SUPPORTED = 30204;
    public static final int E_RESOURCE_FONT_REGISTER_FAILED = 30205;
    public static final int E_RESOURCE_FONT_RESOURCE_LOAD_ERROR = 30202;
    public static final int E_RESOURCE_FONT_SRC_FORMAT_ERROR = 30201;
    public static final int E_RESOURCE_I18N = 30400;
    public static final int E_RESOURCE_IMAGE_BIG_IMAGE = 30101;
    public static final int E_RESOURCE_IMAGE_EXCEPTION = 30199;
    public static final int E_RESOURCE_IMAGE_FROM_NETWORK_OR_OTHERS = 30196;
    public static final int E_RESOURCE_IMAGE_FROM_USER_OR_DESIGN = 30103;
    public static final int E_RESOURCE_IMAGE_PIC_SOURCE = 30102;
    public static final int E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST = 32102;
    public static final int E_RESOURCE_MODULE_PARAMS_ERROR = 32101;
    public static final int E_RESOURCE_MODULE_RESOURCE_SERVICE_NOT_EXIST = 32103;
    public static final int E_SSR_DECODE = 140100;
    public static final int E_SSR_DECODE_API_VERSION_NOT_SUPPORTED = 140101;
    public static final int E_SSR_DECODE_SCRIPT = 140102;
    public static final int E_SSR_HYDRATE_DOM_DEVIATE_FROM_SSR_RESULT = 140401;
    public static final int E_SSR_LOAD_UNINITIALIZED = 140201;
    public static final int E_SUCCESS = 0;
    public static final int E_THREAD_WRONG_THREAD_DESTROY_ERROR = 120201;
    public static final int E_THREAD_WRONG_THREAD_SYNC_FLUSH_ERROR = 120202;
    public static final int E_WORKLET_MODULE_EXCEPTION = 190300;
    public static final int E_WORKLET_MTS_CALL_EXCEPTION = 190100;
    public static final int E_WORKLET_RAF_CALL_EXCEPTION = 190200;

    /* loaded from: classes6.dex */
    enum Level {
        FATAL("fatal"),
        ERROR("error"),
        WARN("warn"),
        UNDECIDED("undecided");

        public final String value;

        Level(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes6.dex */
    enum Consumer {
        FRONT_END("front-end"),
        CLIENT(SubTaskRequestMessage.EXECUTOR_CLIENT),
        LYNX("lynx");

        public final String value;

        Consumer(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes6.dex */
    static class MetaData {
        public final List<Consumer> mConsumer;
        public final String mFixSuggestion;
        public final Level mLevel;

        MetaData(Level level, String str, List<Consumer> list) {
            this.mLevel = level;
            this.mFixSuggestion = str;
            this.mConsumer = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static MetaData getMetaData(int i) {
        switch (i) {
            case 0:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case 10201:
                return new MetaData(Level.FATAL, "Should not call `loadTemplate` while the rendering pipeline of app bundle has not finished", Arrays.asList(new Consumer[0]));
            case 10202:
                return new MetaData(Level.FATAL, "Please call the initialization method of LynxEnv before loadTemplate.", Arrays.asList(Consumer.CLIENT));
            case 10203:
                return new MetaData(Level.FATAL, "Please check if the app bundle is available", Arrays.asList(new Consumer[0]));
            case 10204:
                return new MetaData(Level.FATAL, "Please check that 1. the provided bundle is an app bundle, 2. the engine version of the bundle is compatible with that of Lynx engine, 3. the bundle file is not broken.", Arrays.asList(new Consumer[0]));
            case 10205:
                return new MetaData(Level.FATAL, "Please check the error message of the bundle.", Arrays.asList(new Consumer[0]));
            case E_APP_BUNDLE_LOAD_EXCEPTION /* 10299 */:
                return new MetaData(Level.FATAL, "", Arrays.asList(new Consumer[0]));
            case E_APP_BUNDLE_RELOAD_EARLY_RELOAD /* 10501 */:
                return new MetaData(Level.ERROR, "Please `loadTemplate` before `reloadTemplate`", Arrays.asList(Consumer.CLIENT));
            case E_APP_BUNDLE_VERIFY_INVALID_SIGNATURE /* 10701 */:
                return new MetaData(Level.FATAL, "Please check if the app bundle has been signed correctly", Arrays.asList(new Consumer[0]));
            case E_BTS_RUNTIME_ERROR /* 20100 */:
                return new MetaData(Level.UNDECIDED, "", Arrays.asList(new Consumer[0]));
            case E_BTS_RUNTIME_ERROR_SCRIPT_ERROR /* 20101 */:
                return new MetaData(Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new Consumer[0]));
            case E_BTS_RUNTIME_ERROR_BYTECODE_SCRIPT_ERROR /* 20102 */:
                return new MetaData(Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new Consumer[0]));
            case E_BTS_RUNTIME_ERROR_BINDINGS_ERROR /* 20103 */:
                return new MetaData(Level.ERROR, "Please check the error message and fix binding API call.", Arrays.asList(new Consumer[0]));
            case 20201:
                return new MetaData(Level.WARN, "Please throttle related calls.", Arrays.asList(new Consumer[0]));
            case 20301:
                return new MetaData(Level.ERROR, "Please see error info.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_IMAGE_BIG_IMAGE /* 30101 */:
                return new MetaData(Level.ERROR, "Please resize the image to appropriate dimensions or enable downsampling.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_IMAGE_PIC_SOURCE /* 30102 */:
                return new MetaData(Level.ERROR, "Possibly due to an unsupported image format or a corrupted file. Please verify the integrity of the image file.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_IMAGE_FROM_USER_OR_DESIGN /* 30103 */:
                return new MetaData(Level.ERROR, "In most cases, the issue arises from a canceled image request or an unavailable network connection.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_IMAGE_FROM_NETWORK_OR_OTHERS /* 30196 */:
                return new MetaData(Level.ERROR, "Please investigate the corresponding image download workflow for potential issues.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_IMAGE_EXCEPTION /* 30199 */:
                return new MetaData(Level.ERROR, "An unidentified exception occurred that cannot be attributed to a specific cause. Please investigate further based on the available details.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT /* 30200 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT_SRC_FORMAT_ERROR /* 30201 */:
                return new MetaData(Level.ERROR, "Please check the font-face format.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT_RESOURCE_LOAD_ERROR /* 30202 */:
                return new MetaData(Level.ERROR, "Please check whether font resource is available.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT_BASE64_PARSING_ERROR /* 30203 */:
                return new MetaData(Level.ERROR, "Please check whether the base64 resource is available.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT_FILE_FORMAT_NOT_SUPPORTED /* 30204 */:
                return new MetaData(Level.ERROR, "Please use a font file in ttf or otf format.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_FONT_REGISTER_FAILED /* 30205 */:
                return new MetaData(Level.UNDECIDED, "If the font is displayed correctly, there is no need to deal with it.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_EXTERNAL_RESOURCE_REQUEST_FAILED /* 30301 */:
                return new MetaData(Level.ERROR, "Please check whether the url of the external resource is available", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_EXTERNAL_RESOURCE_LOCAL_RESOURCE_LOAD_FAIL /* 30302 */:
                return new MetaData(Level.ERROR, "Please check whether the local external resource is available", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_I18N /* 30400 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_MODULE_PARAMS_ERROR /* 32101 */:
                return new MetaData(Level.ERROR, "Please refer to the parameter descriptions of this API in documentation and check the parameters used in the call.", Arrays.asList(Consumer.FRONT_END));
            case E_RESOURCE_MODULE_IMG_PREFETCH_HELPER_NOT_EXIST /* 32102 */:
                return new MetaData(Level.ERROR, "Please refer to the official documentation to integrate LynxImageService into your app.", Arrays.asList(Consumer.CLIENT));
            case E_RESOURCE_MODULE_RESOURCE_SERVICE_NOT_EXIST /* 32103 */:
                return new MetaData(Level.ERROR, "Please refer to the official documentation to implement the ILynxResourceService and integrate it into your app.", Arrays.asList(Consumer.CLIENT));
            case E_RESOURCE_CUSTOM /* 39800 */:
                return new MetaData(Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new Consumer[0]));
            case E_RESOURCE_EXCEPTION /* 39900 */:
                return new MetaData(Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new Consumer[0]));
            case E_DATA_FLOW_UPDATE_INVALID_PROCESSOR /* 40101 */:
                return new MetaData(Level.ERROR, "Should not call `getDerivedStateFromProps`, `getDerivedStateFromError`, `shouldComponentUpdate` as data processor.", Arrays.asList(new Consumer[0]));
            case E_DATA_FLOW_UPDATE_INVALID_TYPE /* 40102 */:
                return new MetaData(Level.ERROR, "Target string data should be enabled to be parsed into a table.", Arrays.asList(new Consumer[0]));
            case E_DATA_FLOW_UPDATE_EXCEPTION /* 40199 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_ELEMENT_API_FATAL /* 50101 */:
                return new MetaData(Level.FATAL, "", Arrays.asList(new Consumer[0]));
            case E_ELEMENT_API_ERROR /* 50102 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_ELEMENT_UPDATE_NODE_IS_NULL /* 50201 */:
                return new MetaData(Level.FATAL, "", Arrays.asList(new Consumer[0]));
            case E_LAYOUT_INTERNAL /* 60100 */:
                return new MetaData(Level.ERROR, "Lynx internal error. Please check whether the creating of corresponding ShadowNode failed", Arrays.asList(new Consumer[0]));
            case E_LAYOUT_PERF_INFINITE_LOOP /* 60201 */:
                return new MetaData(Level.ERROR, "Infinite loop of layout happens. It usually happens when the front-end decides the content size based on the viewport size, while the client is deciding the viewport size based on the content size.", Arrays.asList(Consumer.FRONT_END));
            case E_LAYOUT_UPDATE_UI_NOT_FOUND /* 60301 */:
                return new MetaData(Level.ERROR, "This is an internal error of Lynx. LynxUI has not been created or the creation failed while updating.", Arrays.asList(new Consumer[0]));
            case E_LAYOUT_PLATFORM_NODE_NULL /* 60401 */:
                return new MetaData(Level.ERROR, "This is an internal error of Lynx, which usually occurs when multiple threads access ShadowNode at the same time.", Arrays.asList(new Consumer[0]));
            case E_NATIVE_MODULES_COMMON_MODULE_NOT_FOUND /* 90101 */:
                return new MetaData(Level.ERROR, "Please verify that the invoked native module name matches the registered name and confirm module registration status.", Arrays.asList(Consumer.CLIENT));
            case E_NATIVE_MODULES_COMMON_FUNCTION_NOT_FOUND /* 90102 */:
                return new MetaData(Level.ERROR, "Please verify proper method registration using platform-specific annotations on Android or static method declarations on iOS (For details, refer to the native module documentation). Additionally, ensure that the invoked method name exactly matches the registered name in the native module implementation.", Arrays.asList(Consumer.CLIENT));
            case E_NATIVE_MODULES_COMMON_WRONG_PARAM_NUM /* 90103 */:
                return new MetaData(Level.ERROR, "Please ensure that the number of parameters passed to the native method exactly matches the declared parameters in the native module implementation.", Arrays.asList(Consumer.FRONT_END));
            case E_NATIVE_MODULES_COMMON_WRONG_PARAM_TYPE /* 90104 */:
                return new MetaData(Level.ERROR, "Please verify that the parameter types in the method call exactly match the native module implementation. Ensure type compatibility across all parameters and validate the parameter order corresponds to the native method signature. You can check the native module documentation for expected data types.", Arrays.asList(Consumer.FRONT_END));
            case E_NATIVE_MODULES_COMMON_AUTHORIZATION_ERROR /* 90105 */:
                return new MetaData(Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new Consumer[0]));
            case E_NATIVE_MODULES_COMMON_SYSTEM_AUTHORIZATION_ERROR /* 90106 */:
                return new MetaData(Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new Consumer[0]));
            case E_NATIVE_MODULES_COMMON_RETURN_ERROR /* 90107 */:
                return new MetaData(Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new Consumer[0]));
            case E_NATIVE_MODULES_COMMON_DEPRECATED /* 90108 */:
                return new MetaData(Level.WARN, "Please migrate deprecated api as soon as possible.", Arrays.asList(new Consumer[0]));
            case E_NATIVE_MODULES_NETWORK_BAD_RESPONSE /* 90801 */:
                return new MetaData(Level.ERROR, "Check if the server's response body is correct; Check if client unexpectedly consumes http response body using network request interceptor; You can use request's url and log id to track down the problem.", Arrays.asList(Consumer.FRONT_END));
            case E_NATIVE_MODULES_CUSTOM_ERROR /* 99800 */:
                return new MetaData(Level.ERROR, "This error is explicitly defined by the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(Consumer.CLIENT));
            case E_NATIVE_MODULES_EXCEPTION /* 99900 */:
                return new MetaData(Level.ERROR, "This error indicates an unhandled runtime exception within the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(Consumer.CLIENT));
            case E_EVENT_EXCEPTION /* 109900 */:
                return new MetaData(Level.ERROR, "This error is caught by the Lynx Engine. Please file an issue to Lynx to help address it.", Arrays.asList(Consumer.LYNX));
            case E_MTS_RUNTIME_ERROR /* 110100 */:
                return new MetaData(Level.UNDECIDED, "", Arrays.asList(new Consumer[0]));
            case E_MTS_RENDERER_FUNCTION_FATAL /* 111101 */:
                return new MetaData(Level.FATAL, "", Arrays.asList(new Consumer[0]));
            case E_MTS_RENDERER_FUNCTION_ERROR /* 111102 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_THREAD_WRONG_THREAD_DESTROY_ERROR /* 120201 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_THREAD_WRONG_THREAD_SYNC_FLUSH_ERROR /* 120202 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_CSS /* 130100 */:
                return new MetaData(Level.UNDECIDED, "", Arrays.asList(new Consumer[0]));
            case E_CSS_UNKNOWN_PROPERTY /* 130101 */:
                return new MetaData(Level.UNDECIDED, "", Arrays.asList(new Consumer[0]));
            case E_CSS_UNSUPPORTED_VALUE /* 130102 */:
                return new MetaData(Level.UNDECIDED, "Please check your value for the property follow the detailed message.", Arrays.asList(new Consumer[0]));
            case E_CSS_COMPUTED_CSS_VALUE_UNKNOWN_SETTER /* 130201 */:
                return new MetaData(Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault", Arrays.asList(new Consumer[0]));
            case E_CSS_COMPUTED_CSS_VALUE_UNKNOWN_GETTER /* 130202 */:
                return new MetaData(Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault.", Arrays.asList(new Consumer[0]));
            case E_CSS_COMPUTED_CSS_VALUE_UNSUPPORTED_INHERITANCE /* 130203 */:
                return new MetaData(Level.ERROR, "Remove property name from inheritance list.", Arrays.asList(new Consumer[0]));
            case E_CSS_PARSER /* 130300 */:
                return new MetaData(Level.ERROR, "Please use values following the property definitions. You can get the definitions at the official website.", Arrays.asList(new Consumer[0]));
            case E_SSR_DECODE /* 140100 */:
                return new MetaData(Level.ERROR, "Please check if the data used to render the page is the same data generated from the SSR server runtime. Or check if SSR is correctly implemented.", Arrays.asList(new Consumer[0]));
            case E_SSR_DECODE_API_VERSION_NOT_SUPPORTED /* 140101 */:
                return new MetaData(Level.ERROR, "Please limit the client version to the ones that support the SSR data sent from the server side.", Arrays.asList(new Consumer[0]));
            case E_SSR_DECODE_SCRIPT /* 140102 */:
                return new MetaData(Level.ERROR, "Check the syntax of the script which is attached with SSR data.", Arrays.asList(new Consumer[0]));
            case E_SSR_LOAD_UNINITIALIZED /* 140201 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_SSR_HYDRATE_DOM_DEVIATE_FROM_SSR_RESULT /* 140401 */:
                return new MetaData(Level.ERROR, "The used app bundle and injected data to hydrate the SSR page should be the same as ones used to render on the server side", Arrays.asList(new Consumer[0]));
            case E_LAZY_BUNDLE_LOAD_BAD_RESPONSE /* 160101 */:
                return new MetaData(Level.ERROR, "Please check whether the url of the lazy bundle is available", Arrays.asList(new Consumer[0]));
            case E_LAZY_BUNDLE_LOAD_EMPTY_FILE /* 160102 */:
                return new MetaData(Level.ERROR, "Please check whether the lazy bundle file is empty", Arrays.asList(new Consumer[0]));
            case E_LAZY_BUNDLE_LOAD_DECODE_FAILED /* 160103 */:
                return new MetaData(Level.ERROR, "Please check whether the lazy bundle file is broken or it is compatible with the host page", Arrays.asList(new Consumer[0]));
            case E_LAZY_BUNDLE_LOAD_BAD_BUNDLE /* 160104 */:
                return new MetaData(Level.ERROR, "Please check the error message of the bundle", Arrays.asList(new Consumer[0]));
            case E_WORKLET_MTS_CALL_EXCEPTION /* 190100 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_WORKLET_RAF_CALL_EXCEPTION /* 190200 */:
                return new MetaData(Level.ERROR, "Calling requestAnimationFrame failed. This is usually caused by an error in the callback function. Please ensure that the callback function executes without errors.", Arrays.asList(new Consumer[0]));
            case E_WORKLET_MODULE_EXCEPTION /* 190300 */:
                return new MetaData(Level.ERROR, "Make sure you have imported worklet file correctly.", Arrays.asList(new Consumer[0]));
            case E_MTS_BRIDGE_MODULE_WRONG_PARAM /* 200101 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_API_DEPRECATED /* 220101 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(Consumer.FRONT_END));
            case E_COMPONENT_LIST_ILLEGAL_ITEM_KEY /* 220201 */:
                return new MetaData(Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_DUPLICATED_CELL /* 220202 */:
                return new MetaData(Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_CELL_NOT_FOUND /* 220203 */:
                return new MetaData(Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_DYNAMIC_CHANGE_ORIENTATION /* 220204 */:
                return new MetaData(Level.ERROR, "Please do not change the value of `vertical-orientation` dynamically.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_INVALID_PROPS_ARG /* 220205 */:
                return new MetaData(Level.ERROR, "For parameter usage, please check documentation of list component.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_CHILD_COMPONENT_NOT_EXIST /* 220206 */:
                return new MetaData(Level.ERROR, "The internal state of the engine has become inconsistent.  Please file an issue to Lynx for help resolving this problem.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_UNSUPPORTED_THREAD_STRATEGY /* 220207 */:
                return new MetaData(Level.ERROR, "Please set the attribute enable-async-list of <list /> to true.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_DUPLICATE_ITEM_KEY /* 220208 */:
                return new MetaData(Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_LIST_SET_UPDATE_ANIMATION_MULTIPLE_TIMES /* 220209 */:
                return new MetaData(Level.ERROR, "Please check the usage of update animation", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_IMAGE_UNSUPPORTED_PROP /* 220301 */:
                return new MetaData(Level.ERROR, "This may be due to platform-specific limitations or system restrictions. If blur-radius is not supported on this platform, consider using CSS filter: blur() as an alternative.", Arrays.asList(new Consumer[0]));
            case E_COMPONENT_CUSTOM /* 229800 */:
                return new MetaData(Level.ERROR, "", Arrays.asList(new Consumer[0]));
            case E_EXCEPTION_PLATFORM /* 990100 */:
                return new MetaData(Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new Consumer[0]));
            case E_EXCEPTION_JNI /* 990200 */:
                return new MetaData(Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new Consumer[0]));
            default:
                return null;
        }
    }
}
