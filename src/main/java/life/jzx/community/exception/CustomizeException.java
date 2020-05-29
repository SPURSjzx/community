package life.jzx.community.exception;

/**
 * @Auther: Administrator
 * @Date: 2020/5/27 0027 17:16
 * @Description:
 */
public class CustomizeException  extends RuntimeException{

    private String message;
    private Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code=errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}
