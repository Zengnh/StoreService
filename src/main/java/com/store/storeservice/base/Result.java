package com.store.storeservice.base;
import java.io.Serializable;
public class Result<T> implements Serializable {
    private T data;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> Result<T> succeed(String msg) {
        return (Result<T>) succeedWith((Object)null, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(), "");
    }

    public static <T> Result<T> succeedWith(T datas, Integer code, String msg) {
        return new Result(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return (Result<T>) failedWith((Object)null, (Integer)CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T datas, String code, String msg) {
        return new Result(datas, Integer.parseInt(code), msg);
    }

    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result(datas, code, msg);
    }

    public static Result returnFlag(boolean flag) {
        return flag ? succeed("操作成功") : failed("操作失败");
    }

    public T getData() {
        return this.data;
    }
    public void setData(T datas) {
        this.data = datas;
    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$datas = this.getData();
                    Object other$datas = other.getData();
                    if (this$datas == null) {
                        if (other$datas == null) {
                            break label47;
                        }
                    } else if (this$datas.equals(other$datas)) {
                        break label47;
                    }

                    return false;
                }

                Object this$resp_code = this.getCode();
                Object other$resp_code = other.getCode();
                if (this$resp_code == null) {
                    if (other$resp_code != null) {
                        return false;
                    }
                } else if (!this$resp_code.equals(other$resp_code)) {
                    return false;
                }

                Object this$resp_msg = this.getMsg();
                Object other$resp_msg = other.getMsg();
                if (this$resp_msg == null) {
                    if (other$resp_msg != null) {
                        return false;
                    }
                } else if (!this$resp_msg.equals(other$resp_msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result = 1;
        Object $datas = this.getData();
        result = result * 59 + ($datas == null ? 43 : $datas.hashCode());
        Object $resp_code = this.getCode();
        result = result * 59 + ($resp_code == null ? 43 : $resp_code.hashCode());
        Object $resp_msg = this.getMsg();
        result = result * 59 + ($resp_msg == null ? 43 : $resp_msg.hashCode());
        return result;
    }

    public String toString() {
        return "Result(datas=" + this.getData() + ", resp_code=" + this.getCode() + ", resp_msg=" + this.getMsg() + ")";
    }

    public Result() {
    }

    public Result(T data, Integer resp_code, String resp_msg) {
        this.data = data;
        this.code = resp_code;
        this.msg = resp_msg;
    }
}
