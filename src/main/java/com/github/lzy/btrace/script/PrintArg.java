package com.github.lzy.btrace.script;

import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;

/**
 * @author liuzhengyang
 */
@BTrace
public class PrintArg {
    static {
        println("System Properties:");
        printProperties();
        println("VM Flags:");
        printVmArguments();
        println("OS Environments:");
        printEnv();
    }

    @OnMethod(clazz = "/com\\.github\\.lzy\\.btrace\\..*/", method = "/invokeMethod/", location
            = @Location(Kind.RETURN))
    public static void printArg(@ProbeClassName String className, @ProbeMethodName String methodName,
            AnyType[] args, @Return AnyType result, @Duration long duration) {
        println("Class: " + className);
        println("Method: " + methodName);
        println("Cost " + duration);
        println("result " + result);
        print("Argument ");
        printArray(args);
        println("Invoke stack: ");
        jstack();
        println("===========================================================");
    }
}
