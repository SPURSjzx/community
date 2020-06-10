package life.jzx.community.service;

import life.jzx.community.dto.CommentDTO;
import life.jzx.community.enums.CommentTypeEnum;
import life.jzx.community.model.Comment;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:33
 * @Description:
 */
public interface CommentService {
    List<CommentDTO> listByQuestionId(Integer id, Integer type);
    void insert(Comment comment);
}
