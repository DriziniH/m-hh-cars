package cars.data;

import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class CarChina extends Car implements Serializable {
    /**
     * Data class for china car data
     */

    private static final long serialVersionUID = 8077655270295790519L;

    public String 模型;
    public List<String> 标签;
    public String 燃料;

    public double 千米_总;
    public double 千米;
    public double 旅行_时候_总;
    public double 旅行_时候;

    public double 油_层次;
    public double 断裂_流畅_层次;
    public double 燃料_层次;

    public double 发动机;
    public double 休息;

    public double 胎压;

    public CarChina(String id) {
        super.id = id;

        // Initialze car direction
        Random rand = new Random();
        super.dirX = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);
        super.dirY = rand.nextDouble() * (rand.nextBoolean() ? -1 : 1);

        super.lat = rand.nextInt(9) + 32 + rand.nextDouble();
        super.lon = rand.nextInt(25) + 93 + rand.nextDouble();

    }

    public void setValues(String 模型, List<String> 标签, String 燃料, double 千米_总, double 千米, double 旅行_时候_总, double 旅行_时候,
            double 油_层次, double 断裂_流畅_层次, double 燃料_层次, double 发动机, double 休息, double 胎压) {

        this.模型 = 模型;
        this.标签 = 标签;
        this.燃料 = 燃料;
        this.千米_总 = 千米_总;
        this.千米 = 千米;
        this.旅行_时候_总 = 旅行_时候_总;
        this.旅行_时候 = 旅行_时候;
        this.油_层次 = 油_层次;
        this.断裂_流畅_层次 = 断裂_流畅_层次;
        this.燃料_层次 = 燃料_层次;
        this.发动机 = 发动机;
        this.休息 = 休息;
        this.胎压 = 胎压;
    }

    @Override
    public void setPos(double lat, double lon){
        super.lat = lat;
        super.lon = lon;
    }

}
