package bean;

import lombok.Data;

public class Username {
    private String reg = "[a-zA-Z]";
    private String regx = "[a-zA-Z0-9_]";
    private String username;
    private Boolean isval;
    private String tip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getIsval() {
        return isValid();
    }

    public void setIsval(Boolean isval) {
        this.isval = isval;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isValid(){
        String name = getUsername();
        String firstName = String.valueOf(name.charAt(0));
        if(firstName.matches(reg)){
            for (int i = 1; i < name.length(); i++) {
                if(!String.valueOf(name.charAt(i)).matches(regx)){
                    setTip("用户姓名错误，只能由字母、数字和下划线组成!");
                    return false;
                }
            }
            setTip("用户格式正确！");
            return true;
        }else {
            setTip("用户姓名错误，首字母必须为字母！");
            return false;
        }
    }
}
