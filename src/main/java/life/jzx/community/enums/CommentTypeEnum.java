package life.jzx.community.enums;

/**
 * @Auther: Administrator
 * @Date: 2020/5/29 0029 09:57
 * @Description:
 */
public enum  CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public static boolean isExist(int type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if(value.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
