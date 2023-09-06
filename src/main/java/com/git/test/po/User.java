package com.git.test.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author authorZhao
 * @since 2023-09-06
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private Integer sex;
    private String avatar;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer dataVersion;
}
