package life.jzx.community.service;

import life.jzx.community.dto.PaginationDTO;

/**
 * @Auther: Administrator
 * @Date: 2020/5/22 0022 10:39
 * @Description:
 */
public interface QuestionService {
    PaginationDTO list(Integer page, Integer size);
}
