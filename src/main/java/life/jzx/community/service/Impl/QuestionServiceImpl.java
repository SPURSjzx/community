package life.jzx.community.service.Impl;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.exception.CustomizeException;
import life.jzx.community.mapper.CommentMapper;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.model.Question;
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

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PaginationDTO listbyid(Integer id, Integer page, Integer size) {
        Integer offset = size * (page-1);
        PaginationDTO paginationDTO = new PaginationDTO();
        List<QuestionDTO> list = questionMapper.list(offset,size);
        paginationDTO.setQuestions(list);
        //查询记录总条数
        Integer count = questionMapper.countbyid(id);
        paginationDTO.setPagination(count,page,size);
        return paginationDTO;
    }

    @Override
    public PaginationDTO list(Integer page, Integer size) {

        //当前页码的第一列数据行数
//        Integer offset;
//        if(page>1){
//            offset = size * (page-1);
//        }else{
//            offset=1;
//        }
        Integer offset = size * (page-1);
        PaginationDTO paginationDTO = new PaginationDTO();
        List<QuestionDTO> list = questionMapper.list(offset,size);
        paginationDTO.setQuestions(list);
        //查询记录总条数
        Integer count = questionMapper.count();
        paginationDTO.setPagination(count,page,size);
        return paginationDTO;
    }

    @Override
    public QuestionDTO getById(Integer id) {
        QuestionDTO questionDTO=questionMapper.getById(id);
        if(questionDTO==null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        return questionDTO;
    }

    @Override
    public void createOrUpdate(QuestionDTO questionDTO) {
        if(questionDTO.getId()==null){
            //创建
            questionDTO.setCommentCount(0);
            questionMapper.create(questionDTO);
        }else{
            questionDTO.setGmtModified(System.currentTimeMillis());
            Integer update =questionMapper.update(questionDTO);
            if(update != null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    @Override
    public void incView(Integer id) {
        QuestionDTO questionDTO = questionMapper.getById(id);
        Question question = new Question();
        question.setViewCount(questionDTO.getViewCount()+1);
        question.setId(questionDTO.getId());
        questionMapper.updateView(question);
    }

}
