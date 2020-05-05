/**
 * Created by xiaoaxiao on 2020/4/27
 * Description:
 */
public class BuyOrNot {

    public String val;

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        }

        if (!(obj instanceof BuyOrNot)){
            return false;
        }

        BuyOrNot other = (BuyOrNot)obj;
        return other.val.equals(this.val);

    }
}
