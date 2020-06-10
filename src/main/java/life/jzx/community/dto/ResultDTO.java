package life.jzx.community.dto;

import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.exception.CustomizeException;
import lombok.Data;

/*
 * @Auther: Administrator
 * @Date: 2020/5/29 0029 09:50
 * @Description:
 */
@Data
public class ResultDTO<T> {

    private Integer code;
    private String message;
    private T data;
    public static ResultDTO errorof(Integer code,String message){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorof(CustomizeErrorCode CustomizeErrorCode) {
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(CustomizeErrorCode.getCode());
        resultDTO.setMessage(CustomizeErrorCode.getMessage());
        return resultDTO;
    }

    public static ResultDTO okof(){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
    public static <T> ResultDTO okof(T t){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setData(t);
        resultDTO.setMessage("请求成功");

        return resultDTO;
    }
    public static ResultDTO errorof(CustomizeException ex) {
        return errorof(ex.getCode(),ex.getMessage());
    }
}
