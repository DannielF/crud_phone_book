package com.dannielf.crud_phone_book.util;

/**
 * Utils class to manage response in the controller
 *
 * @version 1.0.0
 * @author Julian Lasso
 * @since 1.0.0
 */
public class Response {
    public Boolean error = false;
    public String message = "";
    public String status = "OK";
    public Object data;
}