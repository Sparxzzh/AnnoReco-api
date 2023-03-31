package com.example.Annoreco.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Content implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private LocalDateTime created;

    private LocalDateTime updated;


}
