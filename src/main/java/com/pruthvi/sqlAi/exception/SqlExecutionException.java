package com.pruthvi.sqlAi.exception;

public class SqlExecutionException extends RuntimeException {

    public final String sql;

    public SqlExecutionException(String message, String sql) {
        super(message);
        this.sql = sql;
    }

    public SqlExecutionException(String message, String sql, Throwable cause) {
        super(message, cause);
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
