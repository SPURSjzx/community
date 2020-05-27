package life.jzx.community.dto;

import life.jzx.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
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
    private boolean showFirstPage;  //第一页按钮
    private boolean showNext;       //下一页
    private boolean showEndPage;    //最后一页

    private Integer page;           //当前页面
    private List<Integer> pages = new ArrayList<>();    //

    public void setPagination(Integer count, Integer page, Integer size) {
        Integer totalPage;
        if(count%size==0){
            totalPage=count/size;
        }else{
            totalPage=count / size+1;
        }
        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if(page-i>0){
                System.out.println(page-i);
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //是否展示上一页
        if(page==1){
            showPrevious=false;
        }else {
            showPrevious=true;
        }
        //是否展示上一页
        if(page==totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else{
            showFirstPage=true;
        }
        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }
    }
}
