package life.jzx.community.service;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.dto.QuestionDTO;

/**
 * @Auther: Administrator
 * @Date: 2020/5/22 0022 10:39
 * @Description:
 */
public interface QuestionService {

    PaginationDTO listbyid(Integer id, Integer page, Integer size);

    PaginationDTO list(Integer page, Integer size);

    QuestionDTO getById(Integer id);

    void createOrUpdate(QuestionDTO questionDTO);

}
