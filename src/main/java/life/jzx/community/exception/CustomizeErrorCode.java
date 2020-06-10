package life.jzx.community.exception;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 09:30
 * @Description:
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找的问题找不到了"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论"),
    NO_LOGIN(2003,"未登录，请先登录"),
    SYESTM_ERROR(20004,"服务器异常"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUNT(2006,"回复的评论不存在了"),
    CONTENT_IS_EMPTY(2007,"内容不能为空"),
    ;
    private String message;
    private Integer code;


    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return null;
    }
}
