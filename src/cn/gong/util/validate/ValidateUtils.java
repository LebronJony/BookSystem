package cn.gong.util.validate;

public class ValidateUtils {
    /*
    验证数据是否为空
    data要执行验证的数据
    数据为空返回false
     */
    public static boolean validateEmpty(String data){
        if (data == null || "".equals(data)){
            return false;
        }
        return true;
    }
}
