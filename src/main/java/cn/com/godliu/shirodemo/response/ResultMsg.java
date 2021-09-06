package cn.com.godliu.shirodemo.response;

public class ResultMsg {
    private int code;
    private String msg;
    private Object resultObj;

    public static ResultMsg ok(){
        return ok(null);
    }

    public static ResultMsg ok(Object obj){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(1);
        resultMsg.setMsg("success");
        if(obj != null)
            resultMsg.setResultObj(obj);
        return resultMsg;
    }

    public static ResultMsg fail(){
        return fail(null);
    }

    public static ResultMsg fail(String errormsg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(-1);
        resultMsg.setMsg(errormsg == null?"":errormsg);
        return resultMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }
}
