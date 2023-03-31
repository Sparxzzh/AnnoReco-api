package com.example.Annoreco.service.impl;

import com.example.Annoreco.entity.Comment;
import com.example.Annoreco.mapper.CommentMapper;
import com.example.Annoreco.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-03-28
 */
@Service
public abstract class  CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
