package com.bytedance.apm.battery.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface BatteryTypeInf {
    public static final String BATTERY_ALARM = "alarm";
    public static final String BATTERY_CONSUME = "battery_consume";
    public static final String BATTERY_CPU_ACTIVE = "cpu_active_time";
    public static final String BATTERY_GROUND_RECORD = "ground_record";
    public static final String BATTERY_LOC_API = "location";
    public static final String BATTERY_NET_ALL_INTERFACE = "traffic_all_interface";
    public static final String BATTERY_NEW_LAUNCH = "new_launch";
    public static final String BATTERY_PACKETS = "traffic_packets";
    public static final String BATTERY_POWER_LOCK = "power";
    public static final String BATTERY_TRAFFIC = "traffic";
}
