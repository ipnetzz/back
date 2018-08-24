package com.ipnet.utility;

import lombok.*;

/**
 * @author lzb
 * @date 2018/7/22 22:21
 */
@AllArgsConstructor
@ToString
@Getter
@Setter
public class IDNotExistsException extends Exception {

    public IDNotExistsException(String message) {
        super(message);
    }
}
