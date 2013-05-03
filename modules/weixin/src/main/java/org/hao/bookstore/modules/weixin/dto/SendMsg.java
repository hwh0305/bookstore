package org.hao.bookstore.modules.weixin.dto;

public abstract class SendMsg extends BaseMsg {

    private static final long serialVersionUID = -8228331797620543045L;
    private int               funcFlag;

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }

}
