package top.huangqsh.core.enums;

public enum ResultEnum {

    /**
     *
     */
    UNKNOWN_ERROR(-1, "未知错误"),
    OPERATION_SUCCESS(200, "操作成功"),
    PARAMETER_ERROR(100, "参数错误"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
