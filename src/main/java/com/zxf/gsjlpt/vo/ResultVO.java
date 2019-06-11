package com.zxf.gsjlpt.vo;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description TODO
 * @Author dell
 * @Date 2019/1/18  14:22
 **/
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Boolean code;

    /**提示信息.*/
    private String message;

    /** 具体内容. */
    private T data;
}
