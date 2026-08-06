package com.bytedance.sdk.account.error.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ErrorHandlerCenter {
    private static final Map<Integer, ErrorHandler> handlerMap = new HashMap();
    private static final List<ErrorHandler> globalHandlerList = new ArrayList();
    private static String passportSupportFlow = "";

    public static void registerErrorHandler(int i, ErrorHandler errorHandler) {
        updatePassportSupportFlow(errorHandler);
        handlerMap.put(Integer.valueOf(i), errorHandler);
    }

    public static String getPassportSupportFlow() {
        return passportSupportFlow;
    }

    public static void registerGlobalHandler(ErrorHandler... errorHandlerArr) {
        updatePassportSupportFlow(errorHandlerArr);
        Collections.addAll(globalHandlerList, errorHandlerArr);
    }

    private static void updatePassportSupportFlow(ErrorHandler... errorHandlerArr) {
        for (ErrorHandler errorHandler : errorHandlerArr) {
            if (!handlerMap.containsValue(errorHandler) && !globalHandlerList.contains(errorHandler)) {
                String name = errorHandler.getName();
                if (passportSupportFlow.length() > 0) {
                    passportSupportFlow += ",";
                }
                passportSupportFlow += name;
            }
        }
    }

    public static ErrorHandler getHandler(int... iArr) {
        for (int i : iArr) {
            ErrorHandler errorHandler = handlerMap.get(Integer.valueOf(i));
            if (errorHandler != null) {
                return errorHandler;
            }
        }
        return null;
    }

    public static Map<Integer, ErrorHandler> getHandlerMap() {
        return handlerMap;
    }

    public static List<ErrorHandler> getGlobalHandlerList() {
        return globalHandlerList;
    }
}
