package com.langg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User
 *
 * @author zh
 * @date 2019/11/13 17:28
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1523247125083026957L;

    private Long id;

    private String name;

    private String password;

    private String desc;
}
