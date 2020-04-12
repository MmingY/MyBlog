package com.ming.blog.bean;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespBean {

    public RespBean(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    String status;
    String msg;
}
