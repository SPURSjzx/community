package life.jzx.community.dto;

import life.jzx.community.model.Question;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/22 0022 17:03
 * @Description:
 */
@Data
public class PaginationDTO {

    private List<QuestionDTO> questions;
    private boolean showPrevious;   //是否有向前按钮 比如 页码为1时没有
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer page;
    private List<Integer> pages;

    public void setPagination(Integer count, Integer page, Integer size) {
        Integer totalPages=0;
        if(count%size==0){
            totalPages=count/size;
        }else{
            totalPages=count / size+1;
        }
    }
}
