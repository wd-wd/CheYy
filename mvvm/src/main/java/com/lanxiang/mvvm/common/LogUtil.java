package com.lanxiang.mvvm.common;


import com.orhanobut.logger.*;

/**
 * @author zhouzeyu
 * @version ${VERSION}
 * @date on 2018/1/5
 * @package com.ehaofang.manager.common.utils
 * @fileName trunk
 * @org www.ehaofang.com
 * @email zero1108@foxmail.com
 * @describe
 */
public class LogUtil {
    /**
     * 初始化log工具，在app入口处调用
     *
     *
     */
    public static void init() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)      //（可选）是否显示线程信息。 默认值为true
                .methodCount(2)               // （可选）要显示的方法行数。 默认2
                .methodOffset(7)               // （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
                .tag("车遥遥")                  //（可选）每个日志的全局标记。 默认PRETTY_LOGGER（如上图）
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static void d(String message) {
        Logger.d(message);
    }

    public static void i(String message) {
        Logger.i(message);
    }

    public static void w(String message, Throwable e) {
        String info = e != null ? e.toString() : "null";
        Logger.w(message + "：" + info);
    }

    public static void e(String message, Throwable e) {
        Logger.e(e, message);
    }

    public static void json(String json) {
        Logger.json(json);
    }
}