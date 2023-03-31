package com.example.Annoreco.service;

import com.example.Annoreco.entity.Annorecuser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-03-28
 */
public interface AnnorecuserService extends IService<Annorecuser> {
    Annorecuser login(String username, String password);

    Annorecuser register(Annorecuser user);
}
