package life.jzx.community.service.Impl;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/22 0022 10:39
 * @Description:
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public PaginationDTO list(Integer page, Integer size) {

        //当前页码的第一列数据行数
        Integer offset = size * (page-1);
        PaginationDTO paginationDTO = new PaginationDTO();
        List<QuestionDTO> list = questionMapper.list(offset,size);
        paginationDTO.setQuestions(list);
        Integer count = questionMapper.count();
        paginationDTO.setPagination(count,page,size);
        return paginationDTO;
    }
}
