package com.drmeph.java9testdrive;

/**
 * Java 9 interfaces can have following type of variables/methods.
 *
 * Constant variables
 * Abstract methods
 * Default methods
 * Static methods
 * Private methods
 * Private Static methods
 */
public class InterfacePrivateMethodTester {

    public static void main(String[] args) {
        LogOracle8 log = new LogOracle8();
        log.logInfo("");
        log.logWarn("");
        log.logError("");
        log.logFatal("");

        LogMySql8 log1 = new LogMySql8();
        log1.logInfo("");
        log1.logWarn("");
        log1.logError("");
        log1.logFatal("");

        LogOracle9 logOracle9 = new LogOracle9();
        logOracle9.logInfo("");
        logOracle9.logWarn("");
        logOracle9.logError("");
        logOracle9.logFatal("");

        LogMySql9 logMySql9 = new LogMySql9();
        logMySql9.logInfo("");
        logMySql9.logWarn("");
        logMySql9.logError("");
        logMySql9.logFatal("");
    }
}

final class LogOracle8 implements Logger8 {}

final class LogMySql8 implements Logger8 {}

final class LogOracle9 implements Logger9 {}

final class LogMySql9 implements Logger9 {}

interface Logger8 {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    default void logInfo(String message) {
        getConnection();
        System.out.println("Log Message : " + "INFO");
        closeConnection();
    }

    default void logWarn(String message) {
        getConnection();
        System.out.println("Log Message : " + "WARN");
        closeConnection();
    }

    default void logError(String message) {
        getConnection();
        System.out.println("Log Message : " + "ERROR");
        closeConnection();
    }

    default void logFatal(String message) {
        getConnection();
        System.out.println("Log Message : " + "FATAL");
        closeConnection();
    }

    static void getConnection() {
        System.out.println("Open Database connection");
    }

    static void closeConnection() {
        System.out.println("Close Database connection");
    }
}

interface Logger9 {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    private void log(String message, String prefix) {
        getConnection();
        System.out.println("Log Message : " + prefix);
        closeConnection();
    }

    default void logInfo(String message) {
        log(message, "INFO");
    }
    default void logWarn(String message) {
        log(message, "WARN");
    }
    default void logError(String message) {
        log(message, "ERROR");
    }
    default void logFatal(String message) {
        log(message, "FATAL");
    }

    private static void getConnection() {
        System.out.println("Open Database connection");
    }
    private static void closeConnection() {
        System.out.println("Close Database connection");
    }
}